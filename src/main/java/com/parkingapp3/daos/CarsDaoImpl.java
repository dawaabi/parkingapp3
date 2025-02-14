package com.parkingapp3.daos;

import com.parkingapp3.exceptions.CarnotfoundException;
import com.parkingapp3.modules.Cars;
import com.parkingapp3.utill.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarsDaoImpl implements CarsDao {
    @Override
    public void parkCar(Cars cars) {try (Connection connection = SQLConnector.establishConnection();) {

        String sql = "insert into cars (id, model, size, color) values (?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cars.getId());
        ps.setString(2, cars.getModel());
        ps.setString(3, cars.getSize());
        ps.setString(4, cars.getColor());


        ps.executeUpdate();

        System.out.println("Added car successfully with id " + cars.getId());

    } catch (SQLException e) {
        e.printStackTrace();
    }

    }

    @Override
    public void moveCar(Cars movedCar, int id) {

    }

    @Override
    public void updateCar(Cars movedCar, int id) {

        try (Connection connection = SQLConnector.establishConnection();) {

            String sql = "update cars set model = ?, size =?, color=?,where id= ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, movedCar.getModel());
            ps.setString(2, movedCar.getSize());
            ps.setString(3, movedCar.getColor());
            ps.setInt(4,id);

            ps.executeUpdate();

            System.out.println("Moved car successfully with id " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnCar(int id) {
        try (Connection connection = SQLConnector.establishConnection();) {

            String sql = "delete from cars where id= ?;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Returned Car successfully with id " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cars getCarById(int id) throws CarnotfoundException {

        try (Connection connection = SQLConnector.establishConnection();) {
            String sql = "select * from student where id= ?"  ;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cars car = new Cars();
                car.setId(rs.getInt("id"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setSize(rs.getString("size"));

                return car;
            }else{
                throw new CarnotfoundException(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Cars> getAllCars() {




        List<Cars> listOfCars = new ArrayList<>();
        try (Connection connection = SQLConnector.establishConnection();) {
            String sql = "select * from cars"  ;

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cars cars = new Cars();
                cars.setId(rs.getInt("id"));
                cars.setModel(rs.getString("model"));
                cars.setColor(rs.getString("color"));
                cars.setSize(rs.getString("size"));
                listOfCars.add(cars);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCars;


    }
}
