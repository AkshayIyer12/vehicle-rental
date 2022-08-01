package com.example.vehiclerental.service.commands.strategy;

import com.example.vehiclerental.interfaces.Strategy;
import com.example.vehiclerental.model.Booking;
import com.example.vehiclerental.model.Input;
import com.example.vehiclerental.model.VehicleMapKey;

import java.util.HashMap;
import java.util.List;

public class Context {

    private Strategy strategy;
    private static Input input;
    private static HashMap<String, List<Booking>> bookingMap;

    public void setInput(HashMap<String, List<Booking>> bookingMap, Input input) {
        this.input = input;
        this.bookingMap = bookingMap;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute(this.bookingMap, this.input);
    }

}
