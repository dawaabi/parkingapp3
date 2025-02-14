package com.parkingapp3.services;

import com.parkingapp3.daos.CarsDaoImpl;
import com.parkingapp3.daos.ParkingAttendantDaoImpl;
import com.parkingapp3.daos.ParkingSlotDaoImpl;
import com.parkingapp3.modules.Cars;
import com.parkingapp3.modules.ParkingSlot;

import java.util.List;
import java.util.Scanner;

public class ParkingSlotService {
    private Scanner scanner;
    private ParkingAttendantDaoImpl pDao;
    private ParkingSlotDaoImpl psDao;
    private CarsDaoImpl cDao;

    public ParkingSlotService(){
        scanner=new Scanner(System.in);
        pDao=new ParkingAttendantDaoImpl();
        psDao = new ParkingSlotDaoImpl();
        cDao=new CarsDaoImpl();


    }

    public void assignCarToParkingSlot(){

        System.out.println("Please Enter the Parking Slot id where you want to park the car");
        int id = scanner.nextInt();
        scanner.nextLine();

        ParkingSlot parkingSlot=psDao.getParkingSlotByID(id);
        System.out.println(parkingSlot);
        System.out.println("Enter your  car id");
        int assignCar_id= scanner.nextInt();
        parkingSlot.setCar_id(assignCar_id);



        psDao.assignCarToParkingSlot(parkingSlot,id);


    }

    public void unAssignCarToParkingSlot(){
        System.out.println("Enter parking Slot that you want to remove the car from : ");
        int id = scanner.nextInt();

        ParkingSlot parkingSlot=psDao.getParkingSlotByID(id);
        List<Cars> alreadyAssignedCars= psDao.getAllAssignedCarsToParkingSlot(id);

        System.out.println("Please enter the car id that you want to unassign from below list : ");


        for(Cars cars:alreadyAssignedCars){
            System.out.println(cars.getId()+" "+cars.getModel());
        }
        int car_id = scanner.nextInt();

psDao.unAssignCarToParkingSlot(id,car_id);
    }




}
