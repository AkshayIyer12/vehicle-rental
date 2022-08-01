package com.example.vehiclerental.service.commands;

import com.example.vehiclerental.service.CommandInputBuilder;
import com.example.vehiclerental.service.commands.strategy.Context;
import com.example.vehiclerental.service.commands.strategy.PricingStrategy;

public class CommandFactory {

    private static volatile CommandFactory INSTANCE = null;
    private static CommandControl commandControl = new CommandControl();
    private static CommandInputBuilder commandInputBuilder = new CommandInputBuilder();
    private static BranchCommand branchCommand = new BranchCommand();
    private static VehicleCommand vehicleCommand = new VehicleCommand();
    private static Context context = new Context();
    private static PricingStrategy pricingStrategy = new PricingStrategy();
    private static BookingCommand bookingCommand = new BookingCommand();
    private static DisplayCommand displayCommand = new DisplayCommand();

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (CommandFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CommandFactory();
                }
            }
        }
        return INSTANCE;
    }

    public static CommandControl getCommandControl() {
        return commandControl;
    }

    public static void setCommandControl(CommandControl commandControl) {
        CommandFactory.commandControl = commandControl;
    }

    public static CommandInputBuilder getCommandInputBuilder() {
        return commandInputBuilder;
    }

    public static void setCommandInputBuilder(CommandInputBuilder commandInputBuilder) {
        CommandFactory.commandInputBuilder = commandInputBuilder;
    }

    public static BranchCommand getBranchCommand() {
        return branchCommand;
    }

    public static void setBranchCommand(BranchCommand branchCommand) {
        CommandFactory.branchCommand = branchCommand;
    }

    public static VehicleCommand getVehicleCommand() {
        return vehicleCommand;
    }

    public static void setVehicleCommand(VehicleCommand vehicleCommand) {
        CommandFactory.vehicleCommand = vehicleCommand;
    }

    public static BookingCommand getBookingCommand() {
        return bookingCommand;
    }

    public static void setBookingCommand(BookingCommand bookingCommand) {
        CommandFactory.bookingCommand = bookingCommand;
    }

    public static DisplayCommand getDisplayCommand() {
        return displayCommand;
    }

    public static void setDisplayCommand(DisplayCommand displayCommand) {
        CommandFactory.displayCommand = displayCommand;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        CommandFactory.context = context;
    }

    public static PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public static void setPricingStrategy(PricingStrategy pricingStrategy) {
        CommandFactory.pricingStrategy = pricingStrategy;
    }
}
