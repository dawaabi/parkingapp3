package com.parkingapp3.daos;

import com.parkingapp3.modules.Cars;

import java.util.List;

public interface CarsDao {
    void parkCar(Cars cars);
    void moveCar(Cars movedCar, int id);

    void updateCar(Cars movedCar, int id);

    void returnCar(int id);
    Cars getCarById(int id);
    List<Cars> getAllCars();
}
