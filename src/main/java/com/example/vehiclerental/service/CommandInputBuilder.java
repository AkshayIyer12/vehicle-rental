package com.example.vehiclerental.service;

import com.example.vehiclerental.enums.Type;
import com.example.vehiclerental.interfaces.InputBuilder;
import com.example.vehiclerental.model.Input;

import java.util.List;

public class CommandInputBuilder implements InputBuilder {
    private Input input;

    public CommandInputBuilder() {
        this.input = new Input();
    }
    public CommandInputBuilder CommandInputBuilder() {
        this.input = new Input();
        return this;
    }

    @Override
    public CommandInputBuilder setOperation(String operation) {
        this.input.setOperation(operation);
        return this;
    }

    @Override
    public CommandInputBuilder setVehicleType(List<Type> types) {
        this.input.setVehicleType(types);
        return this;
    }

    @Override
    public CommandInputBuilder setVehicleID(String vehicleID) {
        this.input.setVehicleID(vehicleID);
        return this;
    }

    @Override
    public CommandInputBuilder setPrice(int price) {
        this.input.setPrice(price);
        return this;
    }

    @Override
    public CommandInputBuilder setStartTime(int start) {
        this.input.setStartTime(start);
        return this;
    }

    @Override
    public CommandInputBuilder setEndTime(int end) {
        this.input.setEndTime(end);
        return this;
    }

    @Override
    public CommandInputBuilder setBranch(String branch) {
        this.input.setBranchID(branch);
        return this;
    }

    @Override
    public CommandInputBuilder clear() {
        if (this.input != null) {
            this.input.clear();
        }
        return this;
    }

    @Override
    public Input build() {
        return this.input;
    }
}
