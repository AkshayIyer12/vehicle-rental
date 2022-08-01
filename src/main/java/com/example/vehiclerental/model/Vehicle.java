package com.example.vehiclerental.model;

import com.example.vehiclerental.enums.Status;
import com.example.vehiclerental.enums.Type;

public class Vehicle {

    private String VehicleID;
    private Type type;
    private int price;
    private Status status;
    private String branchID;

    public Vehicle(String vehicleID, Type type, int price, Status status, String branchID) {
        VehicleID = vehicleID;
        this.type = type;
        this.price = price;
        this.status = status;
        this.branchID = branchID;
    }

    public String getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(String vehicleID) {
        VehicleID = vehicleID;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VehicleID='" + VehicleID + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", status=" + status +
                ", branchID='" + branchID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (!VehicleID.equals(vehicle.VehicleID)) return false;
        if (type != vehicle.type) return false;
        return branchID.equals(vehicle.branchID);
    }

    @Override
    public int hashCode() {
        int result = VehicleID.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + branchID.hashCode();
        return result;
    }
}
