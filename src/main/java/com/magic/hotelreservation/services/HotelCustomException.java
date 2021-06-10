package com.magic.hotelreservation.services;

public class HotelCustomException extends RuntimeException{
    public ExceptionType exceptionType;
    public enum ExceptionType{
        INVALID_DATE_FORMAT("enter a valid date of format dd-MM-yyyy");

    public String message;
    ExceptionType(String message){
        this.message=message;
    }
    }
    public HotelCustomException(ExceptionType exceptionType){
        super(exceptionType.message);
        this.exceptionType=exceptionType;
    }

}
