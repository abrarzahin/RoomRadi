package com.fullstack.abrarzahin.angularspring.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.abrarzahin.angularspring.entity.ReservationEntity;
import com.fullstack.abrarzahin.angularspring.entity.RoomEntity;
import com.fullstack.abrarzahin.angularspring.model.request.ReservationRequest;
import com.fullstack.abrarzahin.angularspring.model.response.ReservableRoomResponse;
import com.fullstack.abrarzahin.angularspring.model.response.ReservationResponse;
import com.fullstack.abrarzahin.angularspring.repository.PageableRoomRepository;
import com.fullstack.abrarzahin.angularspring.repository.ReservationRepository;
import com.fullstack.abrarzahin.angularspring.repository.RoomRepository;

import convertor.RoomEntityToReservableRoomResponseConverter;




@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {
	@Autowired
	PageableRoomRepository pageableRoomRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ConversionService conversionService;
	
	public RoomEntityToReservableRoomResponseConverter converter;
	
	@RequestMapping(path="",method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRooms(
			@RequestParam(value = "checkin")
			@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
			LocalDate checkin,
			@RequestParam(value = "checkout")
			@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
			LocalDate checkout,Pageable pageable
			
			){
		
		Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
		
		
		return roomEntityList.map(converter::convert);
		
	}
	
	@RequestMapping(path = "/{roomId}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(
			@PathVariable
			Long roomId
			){
		
		roomRepository.findById(roomId);
		
		return null;
		
		
	}
	
	
	
	
	
	@RequestMapping(path = "", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(
			@RequestBody
			ReservationRequest reservationRequest)
	{
		ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
		reservationRepository.save(reservationEntity);
		
		RoomEntity roomEntity = (RoomEntity) roomRepository.findAllById(reservationRequest.getRoomId());
		roomEntity.addReservationEntity(reservationEntity); 
		roomRepository.save(roomEntity);
		reservationEntity.setRoomEntity(roomEntity);
		
		
		ReservationResponse reservationResponse=
				conversionService.convert(reservationEntity, ReservationResponse.class);
		
		
		
		return new ResponseEntity<>(reservationResponse,HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservableRoomResponse> updateReservation(
			@RequestBody
			ReservationRequest reservationRequest)
	{
		return new ResponseEntity<>(new ReservableRoomResponse(),HttpStatus.OK);
	}
	
	@RequestMapping(path= "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(
			@PathVariable
			long reservationId){
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}