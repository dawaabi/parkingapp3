package com.parkingapp3.services;

import com.parkingapp3.daos.CarsDaoImpl;
import com.parkingapp3.modules.Cars;

import java.util.List;
import java.util.Scanner;

public class CarsService {
    private Scanner scanner;
    private CarsDaoImpl cDao;


    public CarsService() {
        scanner = new Scanner(System.in);
        cDao = new CarsDaoImpl();

    }
    public void parkcar() {
        System.out.println("Enter car id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter car model: ");
        String model = scanner.nextLine();

        System.out.println("Enter car size: ");
        String size = scanner.nextLine();
        System.out.println("Enter car color: ");
        String color = scanner.nextLine();

        Cars cars = new Cars(id, model, size, color);
        cDao.parkCar(cars);

    }

    public void viewCar(){
        System.out.println("Enter car id that you are looking for: ");
        int id = scanner.nextInt();

        Cars car = cDao.getCarById(id);
        System.out.println("🧑‍🎓" + car);
    }



    public void updateCar(){
        System.out.println("Enter car id that you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Cars car = cDao.getCarById(id);
        System.out.println(car);
        System.out.println("Which  information would you like to update?");
        System.out.println("1. Model, 2. Size, 3. color");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1){
            System.out.println("Enter updated car model :");
            String updatedcar = scanner.nextLine();
            car.setModel(updatedcar);
        }else if(choice == 2){
            System.out.println("Enter updated car size :");
            String updatedsize = scanner.nextLine();
            car.setSize(updatedsize);
        }else if(choice == 3){
            System.out.println("Enter updated car color :");
            String updatedcolor = scanner.nextLine();
            car.setColor(updatedcolor);

        }else{
            System.out.println("Invalid choice");
        }

        cDao.updateCar(car, id);

    }
    public void returncar(){
        System.out.println("Enter car id that you want to return: ");
        int id = scanner.nextInt();
        cDao.returnCar(id);
    }
    public void getAllCars(){
        List<Cars> cars = cDao.getAllCars();

        for(Cars car : cars){
            System.out.println(car);

            }
        }

    }



