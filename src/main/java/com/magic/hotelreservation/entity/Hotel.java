package com.magic.hotelreservation.entity;

import java.lang.reflect.Method;

public class Hotel {
    private String hotelName;
    private Integer WeekdaysRates;
    private Integer WeekendRates;

    public Hotel(String hotelName, Integer WeekdaysRates,Integer WeekendRates) {
        this.hotelName = hotelName;
        this.WeekdaysRates=WeekdaysRates;
        this.WeekendRates=WeekendRates;
    }

    public Integer getWeekendRates() {
        return WeekendRates;
    }

    public void setWeekendRates(Integer weekendRates) {
        WeekendRates = weekendRates;
    }

    public Integer getWeekdaysRates() {
        return WeekdaysRates;
    }

    public void setWeekDaysRates(Integer rates) {
        this.WeekdaysRates = rates;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

}
