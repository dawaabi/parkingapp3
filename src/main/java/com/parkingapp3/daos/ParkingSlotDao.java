package com.parkingapp3.daos;

import com.parkingapp3.modules.Cars;
import com.parkingapp3.modules.ParkingSlot;

import java.util.List;

public interface ParkingSlotDao {

    void assignCarToParkingSlot(ParkingSlot parkingSlot, int parking_slot_id);

    List<Cars> getAllAssignedCarsToParkingSlot(int parking_slot_id);

    void unAssignCarToParkingSlot(int id, int car_id);

    ParkingSlot getParkingSlotByID(int id);



}