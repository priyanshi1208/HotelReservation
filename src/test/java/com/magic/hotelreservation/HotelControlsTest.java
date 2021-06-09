package com.magic.hotelreservation;

import com.magic.hotelreservation.entity.Hotel;
import com.magic.hotelreservation.services.CrudHotel;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelControlsTest {
    @Test
    public void validating_ratings_for_a_hotel() {
        CrudHotel crudHotel = new CrudHotel();
        crudHotel.addHotelForRegularCustomer("Lakewood", 110, 90, 3);
        crudHotel.addHotelForRegularCustomer("Bridgewood", 80, 100, 4);
        crudHotel.addHotelForRegularCustomer("Ridgewood", 80, 100, 5);
        Integer ratings = crudHotel.hotelList.get(0).getRatings();
        Assert.assertEquals(Optional.ofNullable(3), Optional.ofNullable(ratings));
    }
}