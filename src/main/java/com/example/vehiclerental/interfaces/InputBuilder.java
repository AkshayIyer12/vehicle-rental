package com.example.vehiclerental.interfaces;

import com.example.vehiclerental.enums.Type;
import com.example.vehiclerental.model.Input;
import com.example.vehiclerental.service.CommandInputBuilder;

import java.util.List;

public interface InputBuilder {
    CommandInputBuilder setOperation(String operation);
    CommandInputBuilder setVehicleType(List<Type> types);
    CommandInputBuilder setVehicleID(String vehicleID);
    CommandInputBuilder setPrice(int price);
    CommandInputBuilder setStartTime(int start);
    CommandInputBuilder setEndTime(int end);
    CommandInputBuilder setBranch(String branch);
    CommandInputBuilder clear();
    Input build();
}
