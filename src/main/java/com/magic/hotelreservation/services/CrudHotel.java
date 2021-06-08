package com.magic.hotelreservation.services;

import com.magic.hotelreservation.entity.Hotel;

import java.util.ArrayList;

public class CrudHotel implements ICrudHotel {
    public ArrayList<Hotel> hotelList=new ArrayList<>();

    @Override
    public void addHotelRegularCustomer(String hotelName, Integer rates) {
        Hotel hotel=new Hotel(hotelName,rates);
        hotelList.add(hotel);
    }

    @Override
    public void viewHotelRegularCustomer() {
        hotelList.forEach(hotel->{
            System.out.println(hotel.getHotelName()+" "+hotel.getRates());
        });
    }
}
