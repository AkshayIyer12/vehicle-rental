package com.example.vehiclerental.service.commands;

import com.example.vehiclerental.enums.Status;
import com.example.vehiclerental.enums.Type;
import com.example.vehiclerental.model.Input;
import com.example.vehiclerental.model.Vehicle;
import com.example.vehiclerental.model.VehicleMapKey;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.example.vehiclerental.util.utility.log;

public class VehicleCommand extends Command {

    private static final boolean EXISTING_SET = true;
    private static CommandFactory factory = CommandFactory.getInstance();
    private static BranchCommand branchCommand = factory.getBranchCommand();
    private static HashMap<VehicleMapKey, TreeSet<Vehicle>> availableVehiclesMap = new HashMap<VehicleMapKey, TreeSet<Vehicle>>();
    private static HashMap<VehicleMapKey, TreeSet<Vehicle>> bookedVehiclesMap = new HashMap<VehicleMapKey, TreeSet<Vehicle>>();

    @Override
    protected void execute(Input input) {
        String branchID = input.getBranchID();
        Type vehicleType = input.getVehicleType().get(0);
        if (branchCommand.vehicleTypeExist(branchID, vehicleType)) {
            String vehicleID = input.getVehicleID();
            VehicleMapKey key = new VehicleMapKey(vehicleType, branchID);
            int price = input.getPrice();
            Vehicle vehicle = new Vehicle(vehicleID, vehicleType, price, Status.AVAILABLE, branchID);
            if (availableVehiclesMap.containsKey(key)) {
                addVehicle(key, vehicle, availableVehiclesMap.get(key), EXISTING_SET);
            } else if (bookedVehiclesMap.containsKey(key)) {
                addVehicle(key, vehicle, bookedVehiclesMap.get(key), !EXISTING_SET);
            } else {
                addToAvailableVehicleMap(key, vehicle);
            }
        } else {
            log("FALSE");
        }
    }

    private void addToAvailableVehicleMap(VehicleMapKey key, Vehicle vehicle) {
        TreeSet<Vehicle> vehicleSet = new TreeSet<>(Comparator.comparing(Vehicle::getPrice));
        vehicleSet.add(vehicle);
        availableVehiclesMap.put(key, vehicleSet);
        log("TRUE");
    }

    private void addVehicle(VehicleMapKey key, Vehicle vehicle, TreeSet<Vehicle> vehicles, boolean existingSet) {
        if (vehicles.contains(vehicle)) {
            log("FALSE");
        } else {
            if (existingSet) {
                vehicles.add(vehicle);
                availableVehiclesMap.put(key, vehicles);
                log("TRUE");
            } else {
                addToAvailableVehicleMap(key, vehicle);
            }
        }
    }

    public boolean vehicleAvailable(VehicleMapKey key) {
        if (availableVehiclesMap.containsKey(key)) {
            return availableVehiclesMap.get(key).size() > 0;
        }
        return false;
    }

    protected boolean bookedVehiclesContain(VehicleMapKey key) {
        if (bookedVehiclesMap.containsKey(key)) {
            return bookedVehiclesMap.get(key).size() > 0;
        }
        return false;
    }

    public Vehicle reserveVehicle(VehicleMapKey key) {
        if (vehicleAvailable(key)) {
            TreeSet<Vehicle> vehicles = availableVehiclesMap.get(key);
            Vehicle vehicle = vehicles.pollFirst();
            vehicle.setStatus(Status.BOOKED);
            if (bookedVehiclesContain(key)) {
                TreeSet<Vehicle> bookedVehicles = bookedVehiclesMap.get(key);
                bookedVehicles.add(vehicle);
                bookedVehiclesMap.put(key, bookedVehicles);
            } else {
                TreeSet<Vehicle> bookedVehicles = new TreeSet<Vehicle>(Comparator.comparing(Vehicle::getPrice));
                bookedVehicles.add(vehicle);
                bookedVehiclesMap.put(key, bookedVehicles);
            }
            return vehicle;
        } else {
            return null;
        }
    }

    protected List<String> getAvailableVehicles(String branchID) {
        Type[] values = Type.values();
        TreeSet<Vehicle> vehicles = new TreeSet<>(Comparator.comparing(Vehicle::getPrice));
        for (int i = 0; i < values.length; i++) {
            VehicleMapKey key = new VehicleMapKey(values[i], branchID);
            if (availableVehiclesMap.containsKey(key)) {
                vehicles.addAll(availableVehiclesMap.get(key));
            }
        }
        List<String> vehicleIds = vehicles.stream().map(entry -> entry.getVehicleID()).collect(Collectors.toList());
        return vehicleIds;
    }

}
