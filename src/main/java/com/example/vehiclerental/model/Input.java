package com.example.vehiclerental.model;

import com.example.vehiclerental.enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Input {
    private String operation;
    private String branchID;
    private List<Type> vehicleType;
    private String vehicleID;
    private int price;
    private int startTime;
    private int endTime;

    public Input() {
    }

    public Input(String operation, String branchID, List<Type> vehicleType, String vehicleID, int price, int startTime, int endTime) {
        this.operation = operation;
        this.branchID = branchID;
        this.vehicleType = Collections.emptyList();
        this.vehicleType.addAll(vehicleType);
        this.vehicleID = vehicleID;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public List<Type> getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(List<Type> vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void clear() {
        this.price = -1;
        this.branchID = null;
        this.operation = null;
        this.endTime = -1;
        this.startTime = -1;
        this.vehicleID = null;
        this.vehicleType = Collections.emptyList();
    }
}
