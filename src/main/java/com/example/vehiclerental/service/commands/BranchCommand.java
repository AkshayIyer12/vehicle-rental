package com.example.vehiclerental.service.commands;

import com.example.vehiclerental.enums.Type;
import com.example.vehiclerental.model.Branch;
import com.example.vehiclerental.model.Input;
import com.example.vehiclerental.util.utility;
import java.util.HashMap;
import static com.example.vehiclerental.util.utility.log;

public class BranchCommand extends Command {
    private static HashMap<String, Branch> branchMap = new HashMap<String, Branch>();
    private static int count = 0;

    @Override
    protected void execute(Input input) {
        String branchID = input.getBranchID();
        if (branchMap.containsKey(branchID)) {
            log("FALSE");
        } else {
            Branch branch = new Branch(branchID, input.getVehicleType());
            branchMap.put(branchID, branch);
            count++;
            log("TRUE");
        }
    }

    protected boolean branchExists(String branchID) {
        return utility.isNotEmpty(branchID) &&
                branchMap.containsKey(branchID);
    }

    protected boolean vehicleTypeExist(String branchID, Type vehicleType) {
        return branchExists(branchID) && branchMap.get(branchID).getTypes().contains(vehicleType);
    }
}
