package com.magic.hotelreservation.services;

import java.util.Date;

public interface ICrudHotel {
   void addHotelForRegularCustomer(String hotelName,Integer WeekDaysRates,Integer WeekendRates);
   Integer cheapestHotelDateWise(String date1,String date2);
   void viewHotelRegularCustomer();
}
