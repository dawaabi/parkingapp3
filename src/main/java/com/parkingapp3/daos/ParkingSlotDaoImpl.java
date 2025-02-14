package com.parkingapp3.daos;

import com.parkingapp3.exceptions.ParkingSlotNotFoundException;
import com.parkingapp3.modules.Cars;
import com.parkingapp3.modules.ParkingSlot;
import com.parkingapp3.utill.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingSlotDaoImpl implements ParkingSlotDao{
    @Override
    public void assignCarToParkingSlot(ParkingSlot parkingSlot, int parking_slot_id) {
        try( Connection connection= SQLConnector.establishConnection()) {
            String Statement="update parking_slot set car_id=? where id=? ";
            PreparedStatement preStat=connection.prepareStatement(Statement);
            preStat.setInt(1,parkingSlot.getCar_id());
            preStat.setInt(2,parking_slot_id);
            preStat.executeUpdate();
            System.out.println("Assigned Car to parking slot succesfully with the parking slot id : "+parking_slot_id);

        }catch (SQLException sql){
            sql.printStackTrace();}




    }

    @Override
    public List<Cars> getAllAssignedCarsToParkingSlot(int parking_slot_id) {

        List<Cars> listOfCars = new ArrayList<>();
        try (Connection connection = SQLConnector.establishConnection();) {
            String sql = "select * from parking_slot where id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, parking_slot_id);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
                int car_id = rs.getInt("car_id");
                String sqlCar = "select * from cars where id= ?";
                PreparedStatement psCar = connection.prepareStatement(sqlCar);
               psCar.setInt(1,car_id);
                ResultSet rsCar = psCar.executeQuery();
                while (rsCar.next()) {
                    Cars cars = new Cars();
                    cars.setId(rsCar.getInt("id"));
                    cars.setModel(rsCar.getString("Model"));
                    cars.setSize(rsCar.getString("size"));
                    cars.setColor(rsCar.getString("color"));
                    listOfCars.add(cars);

                }
            }
            return listOfCars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCars;
    }

    @Override
    public void unAssignCarToParkingSlot(int id, int car_id) {
        try (Connection connection = SQLConnector.establishConnection()) {
            String sql = "delete from parking_slot where car_id = ? and id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,car_id);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("unAssigned from parking slot id " + id+ " the car with id " + car_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public ParkingSlot getParkingSlotByID(int id) throws ParkingSlotNotFoundException {

        try( Connection connection= SQLConnector.establishConnection()) {
            String Statement="select * from parking_slot where id=? ";
            PreparedStatement preStat=connection.prepareStatement(Statement);
            preStat.setInt(1,id);

            ResultSet rs= preStat.executeQuery();
            if(rs.next()){

               Cars cars=new Cars();
                ParkingSlot parkingSlot=new ParkingSlot();
                parkingSlot.setId(rs.getInt("id"));


                parkingSlot.setSlot_number(rs.getInt("slot_number"));
                parkingSlot.setSlot_availability(rs.getString("slot_availability"));
                parkingSlot.setCar_id(rs.getInt("car_id"));

                return parkingSlot;
            }
            else {

                throw new ParkingSlotNotFoundException(id);
            }


        }catch (SQLException sql){
            sql.printStackTrace();}


        return null;
    }
}
