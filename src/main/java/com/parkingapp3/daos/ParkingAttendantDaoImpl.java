package com.parkingapp3.daos;

import com.parkingapp3.exceptions.ParkingAttendantNotFoundException;
import com.parkingapp3.modules.Cars;
import com.parkingapp3.modules.ParkingAttendants;
import com.parkingapp3.utill.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingAttendantDaoImpl implements ParkingAttendantsDao {
    @Override
    public void insertParkingAttendant(ParkingAttendants parkingAttendant) {

        try (Connection connection = SQLConnector.establishConnection();) {
            String sql = "insert into ParkingAttendants (id, name, email, address) values (?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, parkingAttendant.getId());
            ps.setString(2, parkingAttendant.getName());
            ps.setString(3, parkingAttendant.getEmail());
            ps.setString(4, parkingAttendant.getAddress());

            ps.executeUpdate();

            System.out.println("Added Parking Attendant successfully with id " + parkingAttendant.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateParkingAttendant(ParkingAttendants updatedParkingAttendant, int id) {


        try (Connection connection = SQLConnector.establishConnection();) {
            String sql = "update ParkingAttendants set name = ?, email=?, address=? where id= ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, updatedParkingAttendant.getName());
            ps.setString(2, updatedParkingAttendant.getEmail());
            ps.setString(3, updatedParkingAttendant.getAddress());
            ps.setInt(4, id);

            ps.executeUpdate();

            System.out.println("Updated Parking Attendant successfully with id " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeParkingAttendant(int id) {

        try (Connection connection = SQLConnector.establishConnection();) {
            String sql = "delete from ParkingAttendants where id= ?;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Deleted Parking Attendant successfully with id " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ParkingAttendants getParkingAttendantById(int id) throws ParkingAttendantNotFoundException {


        try (Connection connection = SQLConnector.establishConnection();) {
            String sql = "select * from ParkingAttendants where id= ?"  ;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ParkingAttendants parkingAttendants = new ParkingAttendants();
                parkingAttendants.setId(rs.getInt("id"));
                parkingAttendants.setName(rs.getString("name"));
                parkingAttendants.setEmail(rs.getString("email"));
                parkingAttendants.setAddress(rs.getString("address"));
                return parkingAttendants;
            }else{
                throw new ParkingAttendantNotFoundException(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;





    }

    @Override
    public List<ParkingAttendants> getAllParkingAttendants() {

        List<ParkingAttendants> listOfParkingAttendants = new ArrayList<>();
        try (Connection connection = SQLConnector.establishConnection();) {
            String sql = "select * from ParkingAttendants";


            PreparedStatement ps = connection.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ParkingAttendants parkingAttendants = new ParkingAttendants();
                parkingAttendants.setId(rs.getInt("id"));
                parkingAttendants.setName(rs.getString("name"));
                parkingAttendants.setEmail(rs.getString("email"));
                parkingAttendants.setAddress(rs.getString("address"));
                listOfParkingAttendants.add(parkingAttendants);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfParkingAttendants;
    }
}
