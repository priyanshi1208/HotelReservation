package com.magic.hotelreservation.services;

import com.magic.hotelreservation.entity.Hotel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.*;

public class CrudHotel implements ICrudHotel {
    public ArrayList<Hotel> hotelList = new ArrayList<>();
    Map<String, Integer> rateList = new HashMap<>();

    @Override
    public void addHotelForRegularCustomer(String hotelName, Integer WeekdaysRates, Integer WeekenedRates,Integer Ratings) {
        Hotel hotel = new Hotel(hotelName, WeekdaysRates, WeekenedRates,Ratings);
        hotelList.add(hotel);
    }

    public LocalDate DateFormatChecker(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            return formatter.parse(date, LocalDate::from);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer cheapestHotelDateWise(String Date1, String Date2) {
        LocalDate startDate = DateFormatChecker(Date1);
        LocalDate endDate = DateFormatChecker(Date2);
        Integer cheapestRate;
        hotelList.forEach(hotel -> {
            AtomicReference<Integer> rate = new AtomicReference<>(0);
            AtomicReference<Integer> finalRate = new AtomicReference<>(0);
            Stream.iterate(startDate, localDate ->
                    localDate.plusDays(1)).limit(DAYS.between(startDate, endDate) + 1).forEach(day -> {
                if (day.getDayOfWeek().equals(DayOfWeek.SUNDAY) || day.getDayOfWeek().equals(DayOfWeek.SATURDAY))
                    rate.set(hotel.getWeekendRates());
                rate.set(hotel.getWeekdaysRates());
                finalRate.set(finalRate.get() + rate.get());
                rateList.put(hotel.getHotelName(),Integer.parseInt(String.valueOf(finalRate)));
            });
        });
        cheapestRate = rateList.values().stream().sorted().collect(Collectors.toList()).get(0);
        rateList.forEach((key, value) -> {
            if (value.equals(cheapestRate))
                System.out.println(key + " ");
        });
        System.out.println(cheapestRate);
        return cheapestRate;
    }

    @Override
    public void viewHotelRegularCustomer() {
        hotelList.forEach(hotel -> System.out.println(hotel.getHotelName() + " " + hotel.getWeekdaysRates()));
    }
}
