package com.example.vehiclerental.service.commands.strategy;

import com.example.vehiclerental.enums.Type;
import com.example.vehiclerental.interfaces.Strategy;
import com.example.vehiclerental.model.Booking;
import com.example.vehiclerental.model.Input;
import com.example.vehiclerental.model.Vehicle;
import com.example.vehiclerental.model.VehicleMapKey;
import com.example.vehiclerental.service.commands.CommandFactory;
import com.example.vehiclerental.service.commands.VehicleCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.vehiclerental.util.utility.log;

public class PricingStrategy implements Strategy {

    private static CommandFactory factory = CommandFactory.getInstance();
    private static VehicleCommand vehicleCommand = factory.getVehicleCommand();


    @Override
    public void execute(HashMap<String, List<Booking>> bookingMap, Input input) {
        String branchID = input.getBranchID();
        Type vehicleType = input.getVehicleType().get(0);
        VehicleMapKey key = new VehicleMapKey(vehicleType, branchID);
        if (vehicleCommand.vehicleAvailable(key)) {
            Vehicle vehicle = vehicleCommand.reserveVehicle(key);
            if (vehicle == null) {
                log("-1");
            } else {
                Booking entry = new Booking(branchID, vehicleType,
                        input.getStartTime(), input.getEndTime(), (input.getEndTime() - input.getStartTime()) * vehicle.getPrice());
                if (bookingMap.containsKey(branchID)) {
                    List<Booking> vehicles = bookingMap.get(branchID);
                    vehicles.add(entry);
                    bookingMap.put(branchID, vehicles);
                } else {
                    List<Booking> vehicles = new ArrayList<>();
                    vehicles.add(entry);
                    bookingMap.put(branchID, vehicles);
                }
                log(Integer.valueOf(entry.getCost()).toString());
            }
        } else {
            log("-1");
        }

    }
}
