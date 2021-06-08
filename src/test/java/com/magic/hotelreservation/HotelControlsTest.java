package com.magic.hotelreservation;

import com.magic.hotelreservation.entity.Hotel;
import com.magic.hotelreservation.services.CrudHotel;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class HotelControlsTest {

    @Test
    public void validate_addition_of_seperate_rates_for_weekend_and_weekdays() {
        CrudHotel hotel=new CrudHotel();
        hotel.addHotelForRegularCustomer("Lakewood",110,90);
        hotel.addHotelForRegularCustomer("Bridgewood",150,50);
        hotel.addHotelForRegularCustomer("Ridgewood",220,150);
        Integer weekendRates = hotel.hotelList.get(2).getWeekendRates();
        Assert.assertEquals(Optional.ofNullable(150),Optional.ofNullable(weekendRates));
    }
    @Test
    public void validate_addition_of_seperate_rates_for_weekdays() {
        CrudHotel hotel=new CrudHotel();
        hotel.addHotelForRegularCustomer("Lakewood",110,90);
        hotel.addHotelForRegularCustomer("Bridgewood",150,50);
        hotel.addHotelForRegularCustomer("Ridgewood",220,150);
        Integer weekendRates = hotel.hotelList.get(0).getWeekdaysRates();
        Assert.assertEquals(Optional.ofNullable(110),Optional.ofNullable(weekendRates));
    }
}