package com.magic.hotelreservation.entity;

public class Hotel {
    private String hotelName;
    private Integer rates;

    public Hotel(String hotelName,Integer rates) {
        this.hotelName = hotelName;
        this.rates=rates;

    }

    public Integer getRates() {
        return rates;
    }

    public void setRates(Integer rates) {
        this.rates = rates;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

}
