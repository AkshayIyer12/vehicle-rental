package com.example.vehiclerental.service.commands;

import com.example.vehiclerental.model.Input;

public abstract class Command {
    protected abstract void execute(Input input);
}