package com.magic.hotelreservation.entity;
public class Hotel {
    private String hotelName;
    private Integer WeekdaysRates;
    private Integer WeekendRates;
    private Integer ratings;
    private CustomerType customerType;

    public Hotel(String hotelName, Integer WeekdaysRates,Integer WeekendRates,Integer ratings,CustomerType customerType) {
        this.hotelName = hotelName;
        this.WeekdaysRates=WeekdaysRates;
        this.WeekendRates=WeekendRates;
        this.ratings=ratings;
        this.customerType=customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
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
