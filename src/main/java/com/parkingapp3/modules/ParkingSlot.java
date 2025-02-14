package com.parkingapp3.modules;

public class ParkingSlot {

    private int  id;
    private  int slot_number;
    private String slot_availability;
    private int car_id;

    public ParkingSlot(){

    }

    public ParkingSlot(int id, int slot_number, String slot_availability, int car_id) {
        this.id = id;
        this.slot_number = slot_number;
        this.slot_availability = slot_availability;
        this.car_id = car_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlot_number() {
        return slot_number;
    }

    public void setSlot_number(int slot_number) {
        this.slot_number = slot_number;
    }

    public String getSlot_availability() {
        return slot_availability;
    }

    public void setSlot_availability(String slot_availability) {
        this.slot_availability = slot_availability;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id=" + id +
                ", slot_number=" + slot_number +
                ", slot_availability='" + slot_availability + '\'' +
                ", car_id=" + car_id +
                '}';
    }
}
