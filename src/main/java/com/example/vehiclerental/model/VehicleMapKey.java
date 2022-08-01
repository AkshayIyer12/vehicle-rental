package com.example.vehiclerental.model;

import com.example.vehiclerental.enums.Type;

public class VehicleMapKey {

    private Type vehicleType;

    private String branchID;

    public VehicleMapKey(Type vehicleType, String branchID) {
        this.vehicleType = vehicleType;
        this.branchID = branchID;
    }
    public Type getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Type vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleMapKey that = (VehicleMapKey) o;

        if (vehicleType != that.vehicleType) return false;
        return branchID.equals(that.branchID);
    }



    @Override
    public int hashCode() {
        int result = vehicleType.hashCode();
        result = 31 * result + branchID.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "VehicleMapKey{" +
                "vehicleType=" + vehicleType +
                ", branchID='" + branchID + '\'' +
                '}';
    }
}
