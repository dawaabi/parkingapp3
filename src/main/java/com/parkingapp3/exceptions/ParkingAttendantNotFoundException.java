package com.parkingapp3.exceptions;

public class ParkingAttendantNotFoundException extends RuntimeException {
  public ParkingAttendantNotFoundException(int ParkingAttendantId) {
    super("Parking Attendant with id " + ParkingAttendantId + " not found");
  }
}
