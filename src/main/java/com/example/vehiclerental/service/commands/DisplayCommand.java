package com.example.vehiclerental.service.commands;

import com.example.vehiclerental.model.Input;
import static com.example.vehiclerental.util.utility.log;

public class DisplayCommand extends Command {

    private static CommandFactory factory = CommandFactory.getInstance();
    private static VehicleCommand vehicleCommand = factory.getVehicleCommand();
    @Override
    protected void execute(Input input) {
        String branchID = input.getBranchID();
        int start_time = input.getStartTime();
        int end_time = input.getEndTime();
        log(String.join(",", vehicleCommand.getAvailableVehicles(branchID)));
    }
}
