package com.example.vehiclerental.model;

import com.example.vehiclerental.enums.Type;

public class Booking {

    private String branchID;
    private Type vehicleType;
    private int start_time;
    private int end_time;
    private int cost;
    private String vehicleID;

    public Booking(String branchID, Type vehicleType, int start_time, int end_time, int price) {
        this.branchID = branchID;
        this.vehicleType = vehicleType;
        this.start_time = start_time;
        this.end_time = end_time;
        this.cost = price;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int price) {
        this.cost = price;
    }

    public Type getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Type vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (start_time != booking.start_time) return false;
        if (end_time != booking.end_time) return false;
        if (cost != booking.cost) return false;
        if (!branchID.equals(booking.branchID)) return false;
        if (vehicleType != booking.vehicleType) return false;
        return vehicleID.equals(booking.vehicleID);
    }

    @Override
    public int hashCode() {
        int result = branchID.hashCode();
        result = 31 * result + vehicleType.hashCode();
        result = 31 * result + start_time;
        result = 31 * result + end_time;
        result = 31 * result + cost;
        result = 31 * result + vehicleID.hashCode();
        return result;
    }
}
