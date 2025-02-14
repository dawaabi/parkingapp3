package com.parkingapp3.daos;

import com.parkingapp3.modules.ParkingAttendants;

import java.util.List;

public interface ParkingAttendantsDao {
    void insertParkingAttendant(ParkingAttendants parkingAttendant);
    void updateParkingAttendant(ParkingAttendants updatedParkingAttendant, int id);
    void removeParkingAttendant(int id);
    ParkingAttendants getParkingAttendantById(int id);
    List<ParkingAttendants> getAllParkingAttendants();

}
