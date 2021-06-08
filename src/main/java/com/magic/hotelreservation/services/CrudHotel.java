package com.magic.hotelreservation.services;

import com.magic.hotelreservation.entity.Hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CrudHotel implements ICrudHotel {
    public ArrayList<Hotel> hotelList=new ArrayList<>();

    @Override
    public void addHotelForRegularCustomer(String hotelName, Integer WeekdaysRates,Integer WeekenedRates) {
        Hotel hotel=new Hotel(hotelName,WeekdaysRates,WeekenedRates);
        hotelList.add(hotel);
    }

    @Override
    public void cheapestHotel(String... dates) {
        Map<String,Integer> rateList=new HashMap<>();
        hotelList.forEach(hotel -> rateList.put(hotel.getHotelName(),hotel.getRates()*dates.length));
        Integer integer = rateList.values().stream().sorted().collect(Collectors.toList()).get(0);
        rateList.forEach((key, value) -> {
            if (value.equals(integer))
                System.out.println(key + " " + value);
        });
    }

    @Override
    public void viewHotelRegularCustomer() {
        hotelList.forEach(hotel-> System.out.println(hotel.getHotelName()+" "+hotel.getRates()));
    }

}
