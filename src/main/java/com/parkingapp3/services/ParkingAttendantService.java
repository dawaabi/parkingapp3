package com.parkingapp3.services;

import com.parkingapp3.daos.ParkingAttendantDaoImpl;
import com.parkingapp3.exceptions.ParkingAttendantNotFoundException;
import com.parkingapp3.modules.ParkingAttendants;

import java.util.List;
import java.util.Scanner;

public class ParkingAttendantService {

    private Scanner scanner;
    private ParkingAttendantDaoImpl pDao;

    public ParkingAttendantService() {
        scanner = new Scanner(System.in);
        pDao = new ParkingAttendantDaoImpl();

    }
    public void createparkingAttendant() {
        System.out.println("Enter Parking Attendant id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Parking Attendant name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter Parking Attendant email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Parking Attendant address: ");
        String address = scanner.nextLine();

        ParkingAttendants parkingAttendant = new ParkingAttendants(id, name, email, address);
        pDao.insertParkingAttendant(parkingAttendant);

    }

    public void viewparkingAttendant() {
        System.out.println("Enter Parking Attendant id that you are looking for: ");
        int id = scanner.nextInt();

      try{  ParkingAttendants parkingAttendants = pDao.getParkingAttendantById(id);
          System.out.println("🧑‍🎓" + parkingAttendants);
      } catch (ParkingAttendantNotFoundException e) {
          e.printStackTrace();
      }

    }


    public void updateparkingAttendant() {
        System.out.println("Enter Parking Attendant id that you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        ParkingAttendants parkingAttendants = pDao.getParkingAttendantById(id);
        System.out.println(parkingAttendants);
        System.out.println("Which information would you like to update?");
        System.out.println("1. NAME, 2. EMAIL, 4. ADDRESS");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Enter updated Parking Attendant name :");
            String updatedName = scanner.nextLine();
            parkingAttendants.setName(updatedName);
        } else if (choice == 2) {
            System.out.println("Enter updated Parking Attendant email :");
            String updatedEmail = scanner.nextLine();
            parkingAttendants.setEmail(updatedEmail);
        } else if (choice == 3) {
            System.out.println("Enter updated Parking Attendant address :");
            String updatedAddress = scanner.nextLine();
            parkingAttendants.setAddress(updatedAddress);

        } else {
            System.out.println("Invalid choice");
        }

        pDao.updateParkingAttendant(parkingAttendants, id);

    }

    public void removeparkingAttendant() {
        System.out.println("Enter Parking Attendant id that you want to remove: ");
        int id = scanner.nextInt();
        pDao.removeParkingAttendant(id);
    }

    public void getAllparkingAttendants() {
        List<ParkingAttendants> parkingAttendants= pDao.getAllParkingAttendants();

        for (ParkingAttendants parkingAttendant : parkingAttendants) {
            System.out.println("🧑‍🎓" + parkingAttendant);


        }

    }
}
