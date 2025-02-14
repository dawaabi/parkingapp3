package com.parkingapp3.exceptions;

public class CarnotfoundException extends RuntimeException {
    public CarnotfoundException(int  carId) {
        super("Car with id " + carId + " not found");
    }
}
