package com.magic.hotelreservation;

import com.magic.hotelreservation.entity.Hotel;
import com.magic.hotelreservation.services.CrudHotel;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class HotelControlsTest {
    @Test
    public void add_name_and_rates_of_hotel_in_reservation_system() {
        CrudHotel hotelservice=new CrudHotel();
        hotelservice.addHotelRegularCustomer("Lakewood",110);
        hotelservice.addHotelRegularCustomer("BridgeWood",160);
        String hotelName = hotelservice.hotelList.get(0).getHotelName();
        Assert.assertEquals("Lakewood",hotelName);
    }

    @Test
    public void Validate_Addition_of_hotel_rates_in_hotel_list() {
        CrudHotel hotelservice=new CrudHotel();
        hotelservice.addHotelRegularCustomer("Lakewood",110);
        hotelservice.addHotelRegularCustomer("BridgeWood",160);
        Optional<Integer> rates = Optional.ofNullable(hotelservice.hotelList.get(1).getRates());
        Assert.assertEquals(Optional.ofNullable(160),rates);
    }
}