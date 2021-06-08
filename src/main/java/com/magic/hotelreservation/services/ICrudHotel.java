package com.magic.hotelreservation.services;

import java.util.Date;

public interface ICrudHotel<E> {
   void addHotelForRegularCustomer(String hotelName,Integer WeekDaysRates,Integer WeekendRates);
   void cheapestHotel(String...dates);
   void viewHotelRegularCustomer();
}
