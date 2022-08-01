package com.example.vehiclerental.service.commands;

import com.example.vehiclerental.enums.Type;
import com.example.vehiclerental.model.Booking;
import com.example.vehiclerental.model.Input;
import com.example.vehiclerental.model.Vehicle;
import com.example.vehiclerental.model.VehicleMapKey;
import com.example.vehiclerental.service.commands.strategy.Context;
import com.example.vehiclerental.service.commands.strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.vehiclerental.util.utility.log;

public class BookingCommand extends Command {

    private static CommandFactory factory = CommandFactory.getInstance();
    private static VehicleCommand vehicleCommand = factory.getVehicleCommand();
    private static Context context = factory.getContext();
    private static PricingStrategy pricingStrategy = factory.getPricingStrategy();

    private static HashMap<String, List<Booking>> bookingMap = new HashMap<String, List<Booking>>();

    @Override
    protected void execute(Input input) {
        context.setInput(bookingMap, input);
        context.setStrategy(pricingStrategy);
        context.executeStrategy();
    }
}
