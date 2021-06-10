package com.magic.hotelreservation;

import com.magic.hotelreservation.entity.CustomerType;
import com.magic.hotelreservation.entity.Hotel;
import com.magic.hotelreservation.services.CrudHotel;
import org.junit.Assert;
import org.junit.Test;
import java.util.Optional;

public class HotelControlsTest {
    @Test
    public void validating_bestRated_CheapestHotel() {
        CrudHotel crudHotel = new CrudHotel();
        crudHotel.addHotelForRegularCustomer("Lakewood",110,90,3, CustomerType.Regular_Customer);
        crudHotel.addHotelForRegularCustomer("Bridgewood",160,60,4, CustomerType.Regular_Customer);
        crudHotel.addHotelForRegularCustomer("Ridgewood",220,150,5, CustomerType.Regular_Customer);
        String Hotelname = crudHotel.cheapestRateAndHighestRated("11-09-2020", "12-09-2020");
        Assert.assertEquals(Optional.ofNullable("Lakewood"), Optional.ofNullable(Hotelname));
    }
}