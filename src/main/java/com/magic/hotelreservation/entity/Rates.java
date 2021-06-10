package com.magic.hotelreservation.entity;

public class Rates {
    private Integer ratings;
    private Integer FinalRate;

    public Rates(Integer ratings, Integer FinalRate){
        this.FinalRate=FinalRate;
        this.ratings=ratings;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public Integer getFinalRate() {
        return FinalRate;
    }

    public void setFinalRate(Integer finalRate) {
        FinalRate = finalRate;
    }
}
