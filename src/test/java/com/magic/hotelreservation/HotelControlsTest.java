package com.magic.hotelreservation;

import com.magic.hotelreservation.entity.CustomerType;
import com.magic.hotelreservation.services.CrudHotel;
import org.junit.Assert;
import org.junit.Test;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class HotelControlsTest {
    @Test
    public void validating_addition_of_special_rates_for_rewarded_customer() {
        CrudHotel crudHotel = new CrudHotel();
        crudHotel.addHotelForRegularCustomer("Lakewood",110,90,3, CustomerType.Regular_Customer);
        crudHotel.addHotelForRegularCustomer("Bridgewood",160,60,4, CustomerType.Regular_Customer);
        crudHotel.addHotelForRegularCustomer("Ridgewood",220,150,5, CustomerType.Regular_Customer);
        crudHotel.addHotelForRegularCustomer("Lakewood",80,80,5, CustomerType.Rewarded_Customer);
        crudHotel.addHotelForRegularCustomer("Bridgewood",110,50,5, CustomerType.Rewarded_Customer);
        crudHotel.addHotelForRegularCustomer("Ridgewood",100,40,5, CustomerType.Rewarded_Customer);
        AtomicReference<Integer> weekdaysRates = new AtomicReference<>(null);
        crudHotel.hotelList.forEach(hotel->{
            if(hotel.getCustomerType().equals(CustomerType.Rewarded_Customer)&&hotel.getHotelName().equals("Lakewood")){
                 weekdaysRates.set(hotel.getWeekdaysRates());
            }
        });
        Assert.assertEquals(80, Integer.parseInt(String.valueOf(weekdaysRates.get())));
    }
    @Test
    public void validating_cheapestHotel_of_special_rates_for_rewarded_customer() {
        CrudHotel crudHotel = new CrudHotel();
        crudHotel.addHotelForRegularCustomer("Lakewood", 110, 90, 3, CustomerType.Regular_Customer);
        crudHotel.addHotelForRegularCustomer("Bridgewood", 160, 60, 4, CustomerType.Regular_Customer);
        crudHotel.addHotelForRegularCustomer("Ridgewood", 220, 150, 5, CustomerType.Regular_Customer);
        crudHotel.addHotelForRegularCustomer("Lakewood", 80, 80, 5, CustomerType.Rewarded_Customer);
        crudHotel.addHotelForRegularCustomer("Bridgewood", 110, 50, 5, CustomerType.Rewarded_Customer);
        crudHotel.addHotelForRegularCustomer("Ridgewood", 100, 40, 5, CustomerType.Rewarded_Customer);
        String hotelname = crudHotel.cheapestRateAndHighestRated("02-02-2020", "03-02-2020", CustomerType.Rewarded_Customer);
        Assert.assertEquals("Ridgewood",hotelname);
    }


}