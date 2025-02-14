package com.parkingapp3.modules;

public class Cars {
   private int id ;
   private String Model ;
   private String size ;
   private String color;


    public Cars(){

    }

    public Cars(int id, String model, String size, String color) {
        this.id = id;
        Model = model;
        this.size = size;
        this.color = color;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", Model='" + Model + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
