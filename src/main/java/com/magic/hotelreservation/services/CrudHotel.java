package com.magic.hotelreservation.services;
import com.magic.hotelreservation.entity.CustomerType;
import com.magic.hotelreservation.entity.Hotel;
import com.magic.hotelreservation.entity.Rates;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.*;

public class CrudHotel implements ICrudHotel {
    public ArrayList<Hotel> hotelList = new ArrayList<>();
    Map<String, Rates> rateList = new HashMap<>();

    @Override
    public void addHotelForRegularCustomer(String hotelName, Integer WeekdaysRates, Integer WeekenedRates, Integer Ratings, CustomerType customerType) {
        Hotel hotel = new Hotel(hotelName, WeekdaysRates, WeekenedRates,Ratings,customerType);
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
    public Rates checkRatings(Integer FinalRates,Integer ratings){
        return new Rates(ratings,FinalRates);

    }
    @Override
    public Integer cheapestHotelDateWise(String Date1, String Date2) {
        LocalDate startDate = DateFormatChecker(Date1);
        LocalDate endDate = DateFormatChecker(Date2);
        hotelList.forEach(hotel -> {
            AtomicReference<Integer> rate = new AtomicReference<>(0);
            AtomicReference<Integer> finalRate = new AtomicReference<>(0);

                Stream.iterate(startDate, localDate ->
                        localDate.plusDays(1)).limit(DAYS.between(startDate, endDate) + 1).forEach(day -> {
                    if (day.getDayOfWeek().equals(DayOfWeek.SUNDAY) || day.getDayOfWeek().equals(DayOfWeek.SATURDAY))
                        rate.set(hotel.getWeekendRates());
                    else{
                    rate.set(hotel.getWeekdaysRates());}
                    finalRate.set(finalRate.get() + rate.get());
                    Rates rates = checkRatings(Integer.parseInt(String.valueOf(finalRate)), hotel.getRatings());
                    rateList.put(hotel.getHotelName(),rates);
                });

        });
        return rateList.values().stream().sorted(Comparator.comparing(Rates::getFinalRate)).collect(Collectors.toList()).get(0).getFinalRate();
    }
    @Override
    public String cheapestRateAndHighestRated(String Date1,String Date2){
        Integer cheapestRate=cheapestHotelDateWise(Date1,Date2);
        AtomicReference<Integer> ratings = new AtomicReference<>(rateList.values().stream().sorted(Comparator.comparing(Rates::getFinalRate)).collect(Collectors.toList()).get(0).getRatings());
        AtomicReference<String> hotelname=new AtomicReference<>(null);
        rateList.forEach((key, value) -> {
            if (value.getFinalRate().equals(cheapestRate)) {
                if(value.getRatings().equals(ratings.get()))
                    hotelname.set(key);
                else if (value.getRatings().compareTo(ratings.get()) > 0){
                    ratings.set(value.getRatings());
                    hotelname.set(key);
                }
            }
        });
        rateList.forEach((key,value)->{
            System.out.println(key+" "+value.getRatings()+" "+value.getFinalRate());
        });
        System.out.println("Hotel:"+hotelname.get()+" "+"Rated:"+ratings+" At price of:"+cheapestRate);
        return hotelname.get();
    }
    @Override
    public void viewHotelRatesForRegularCustomers() {
        hotelList.forEach(hotel->{
            if(hotel.getCustomerType().equals(CustomerType.Regular_Customer))
                System.out.println("Hotel:"+hotel.getHotelName()+" Price for Regular customer:Weekdays-"+hotel.getWeekdaysRates()+" Weekends-"+hotel.getWeekendRates());
        });
    }
}

