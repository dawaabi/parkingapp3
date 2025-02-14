package com.parkingapp3.controllers;

import com.parkingapp3.modules.ParkingAttendants;
import com.parkingapp3.services.CarsService;
import com.parkingapp3.services.ParkingAttendantService;
import com.parkingapp3.services.ParkingSlotService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {Scanner scanner = new Scanner(System.in);

        CarsService carServiceObject = new CarsService();
        ParkingAttendantService parkingAttendantServiceObject = new ParkingAttendantService();
        ParkingSlotService parkingSlotServiceObject = new ParkingSlotService();
        boolean exit = false;
        while(!exit){
            System.out.println("Welcome to Our Garage....!");
            System.out.println(""" 
                    ----------------------------------------------------------------------------------------------------------------------------------
                    | 1. park Car
                    | 2. view Car
                    | 3. update Car
                    | 4. return Car
                    | 5. view all cars
                    | 6. create Parking Attendant
                    | 7. update Parking Attendant
                    | 8. view Parking Attendant
                    | 9. delete Parking Attendant
                    | 10. get all Parking Attendants
                    | 11. assign car to parking slot
                    | 12. unassign car from parking slot
                    | 13. exit
                    -----------------------------------------------------------------------------------------------------------------------------------
                    """);
            System.out.println("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    carServiceObject.parkcar();
                    break;
                case 2:
                    carServiceObject.viewCar();
                    break;
                case 3:
                    carServiceObject.updateCar();
                    break;
                case 4:
                    carServiceObject.returncar();
                    break;
                case 5:
                    carServiceObject.getAllCars();
                    break;
                case 6:
                    parkingAttendantServiceObject.createparkingAttendant();
                    break;
                case 7:
                    parkingAttendantServiceObject.updateparkingAttendant();
                    break;
                case 8:
                    parkingAttendantServiceObject.viewparkingAttendant();
                    break;
                case 9:
                    parkingAttendantServiceObject.removeparkingAttendant();
                case 10:
                    parkingAttendantServiceObject.getAllparkingAttendants();
                    break;
                case 11:
                    parkingSlotServiceObject.assignCarToParkingSlot();
                    break;
                case 12:
                    parkingSlotServiceObject.unAssignCarToParkingSlot();
                    break;
                case 13:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }


        }

    }

}

