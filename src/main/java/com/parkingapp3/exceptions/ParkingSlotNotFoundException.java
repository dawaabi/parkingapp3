package com.parkingapp3.exceptions;

public class ParkingSlotNotFoundException extends RuntimeException {
    public ParkingSlotNotFoundException(int ParkingSlot_Id) {
        super("Parking Slot with id " + ParkingSlot_Id + " not found");
    }
}
