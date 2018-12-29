package convertor;

import org.springframework.core.convert.converter.Converter;

import com.fullstack.abrarzahin.angularspring.entity.RoomEntity;
import com.fullstack.abrarzahin.angularspring.model.Links;
import com.fullstack.abrarzahin.angularspring.model.Self;
import com.fullstack.abrarzahin.angularspring.model.response.ReservationResponse;
import com.fullstack.abrarzahin.angularspring.rest.ResourceConstants;

public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse> {

	@Override
	public ReservationResponse convert(RoomEntity source) {
		// TODO Auto-generated method stub
		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" +source.getId());
		reservationResponse.setLinks(links);
		
		
		
		return null;
	}

	
	
	
}
