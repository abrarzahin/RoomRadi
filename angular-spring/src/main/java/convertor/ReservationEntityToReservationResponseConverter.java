package convertor;

import org.springframework.core.convert.converter.Converter;

import com.fullstack.abrarzahin.angularspring.entity.ReservationEntity;
import com.fullstack.abrarzahin.angularspring.model.response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity,ReservationResponse> {

	@Override
	public ReservationResponse convert(ReservationEntity source) {

		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setCheckin(source.getCheckin());
		reservationResponse.setCheckout(source.getCheckout());
		
		
		return reservationResponse;
	}

}
