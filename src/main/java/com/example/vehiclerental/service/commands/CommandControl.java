package com.example.vehiclerental.service.commands;

import com.example.vehiclerental.model.Input;

public class CommandControl {
    private Command command;
    public CommandControl() {

    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void run(Input input) {
        this.command.execute(input);
    }
}
