package com.example.vehiclerental.interfaces;

import com.example.vehiclerental.model.Booking;
import com.example.vehiclerental.model.Input;
import com.example.vehiclerental.model.VehicleMapKey;

import java.util.HashMap;
import java.util.List;

public interface Strategy {

    void execute(HashMap<String, List<Booking>> bookingMap, Input input);
}
