package convertor;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

import com.fullstack.abrarzahin.angularspring.entity.RoomEntity;
import com.fullstack.abrarzahin.angularspring.model.Links;
import com.fullstack.abrarzahin.angularspring.model.Self;
import com.fullstack.abrarzahin.angularspring.model.response.ReservableRoomResponse;
import com.fullstack.abrarzahin.angularspring.rest.ResourceConstants;
@Component
public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

	@Override
	@Bean
	public ReservableRoomResponse convert(RoomEntity source) {
		// TODO Auto-generated method stub
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" +source.getId());
		links.setSelf(self);
		reservationResponse.setLinks(links);
		
		return reservationResponse;
	}

	
	
	
}