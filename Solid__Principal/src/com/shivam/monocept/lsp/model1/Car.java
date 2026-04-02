package com.shivam.monocept.lsp.model1;

public class Car extends FuelVehicle {
    @Override
    public void start() {
        System.out.println("Car starting...");
    }

    @Override
    public void refuel() {
        System.out.println("Car refueling...");
    }
}