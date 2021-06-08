package com.magic.hotelreservation.services;

import java.util.Date;

public interface ICrudHotel<E> {
   void addHotelRegularCustomer(String hotelName,Integer rates);
   void cheapestHotel(String...dates);
   void viewHotelRegularCustomer();
}
