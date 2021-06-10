package com.magic.hotelreservation.services;

import com.magic.hotelreservation.entity.CustomerType;

import java.util.Date;

public interface ICrudHotel {
   void addHotelForRegularCustomer(String hotelName, Integer WeekDaysRates, Integer WeekendRates, Integer Ratings, CustomerType customerType);
   Integer cheapestHotelDateWise(String date1,String date2);
   String cheapestRateAndHighestRated(String Date1,String Date2);
   void viewHotelRatesForRegularCustomers();
}
