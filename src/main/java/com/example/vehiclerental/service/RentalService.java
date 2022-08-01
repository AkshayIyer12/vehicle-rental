package com.example.vehiclerental.service;

import com.example.vehiclerental.enums.Type;
import com.example.vehiclerental.model.Input;
import com.example.vehiclerental.service.commands.*;
import static com.example.vehiclerental.util.utility.log;
import java.util.*;
import java.util.stream.Collectors;

public class RentalService {


    private static CommandFactory factory = CommandFactory.getInstance();
    private static CommandInputBuilder commandInputBuilder = factory.getCommandInputBuilder();
    private static CommandControl commandControl = factory.getCommandControl();
    private static BranchCommand branchCommand = factory.getBranchCommand();
    private static BookingCommand bookingCommand = factory.getBookingCommand();
    private static VehicleCommand vehicleCommand = factory.getVehicleCommand();
    private static DisplayCommand displayCommand = factory.getDisplayCommand();

    private static final String ADD_BRANCH = "ADD_BRANCH";
    private static final String ADD_VEHICLE = "ADD_VEHICLE";
    private static final String BOOK_VEHICLE = "BOOK";
    private static final String DISPLAY_VEHICLES = "DISPLAY_VEHICLES";

    public void process(String arguments) {
        String[] args = arguments.split(" ");
        String operation = args[0];
        String branch = args[1];
        commandInputBuilder.clear().setOperation(operation).setBranch(branch);

        switch (operation) {
            case ADD_BRANCH: {
                List<Type> vehicleTypes = Arrays.asList(args[2].split(","))
                        .stream()
                        .filter(Objects::nonNull)
                        .map(type -> Type.getType(type))
                        .collect(Collectors.toList());

                commandInputBuilder.setVehicleType(vehicleTypes);
                commandControl.setCommand(branchCommand);
                break;
            }
            case ADD_VEHICLE: {
                commandInputBuilder.setVehicleType(Arrays.asList(Type.getType(args[2])))
                        .setVehicleID(args[3])
                        .setPrice(Integer.parseInt(args[4]));
                commandControl.setCommand(vehicleCommand);
                break;
            }
            case BOOK_VEHICLE: {
                commandInputBuilder.setVehicleType(Arrays.asList(Type.getType(args[2])))
                        .setStartTime(Integer.parseInt(args[3]))
                        .setEndTime(Integer.parseInt(args[4]));
                commandControl.setCommand(bookingCommand);
                break;
            }
            case DISPLAY_VEHICLES: {
                commandInputBuilder.setStartTime(Integer.parseInt(args[2]))
                        .setEndTime(Integer.parseInt(args[3]));
                commandControl.setCommand(displayCommand);
                break;
            }
            default: {
                log("No such command available: "+operation);
                return;
            }
        }
        Input input = commandInputBuilder.build();
        commandControl.run(input);
    }
}
