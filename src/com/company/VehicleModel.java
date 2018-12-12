package com.company;

import java.util.ArrayList;
import java.util.List;

public class VehicleModel {

    private int gasAmount = 0;

    private int brakeAmount = 0;

    private List<MotorizedVehicle> mVehicles = new ArrayList<>();

    public List<MotorizedVehicle> getmVehicles(){
        return mVehicles;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
        this.brakeAmount = gasAmount;
    }


    private void addVehicle(MotorizedVehicle vehicle) {
        mVehicles.add(vehicle);
    }

    public void createAndAddSaab(int x, int y, CardinalDirections.cardinalDirection direction) {
        Saab95 saab95 = new Saab95(x, y, direction);
        addVehicle(saab95);
    }

    public void createAndAddVolvo(int x, int y, CardinalDirections.cardinalDirection direction) {
        Volvo240 volvo = new Volvo240(x, y, direction);
        addVehicle(volvo);
    }

    public void createAndAddScania(int x, int y, CardinalDirections.cardinalDirection direction) {
        Scania scania = new Scania(x, y, direction);
        addVehicle(scania);
    }

    public void moveAllVehicles(){
        for(MotorizedVehicle vehicle : mVehicles) {
            moveVehicle(vehicle);
        }
    }

    private void moveVehicle(MotorizedVehicle vehicle){
        vehicle.move();
        if (vehicle.getPosition().getX() > 800 - 100 || vehicle.getPosition().getY() > (800 - 240 - 60) || vehicle.getPosition().getX() < 0 || vehicle.getPosition().getY() < 0) {
            vehicle.flipDirection();
        }
    }

    // Calls the gas method for each mVehicle once
    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorizedVehicle mVehicle : mVehicles
        ) {
            mVehicle.gas(gas);
        }
    }

    public void gas(){
        gas(gasAmount);
    }

    private void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorizedVehicle mVehicle : mVehicles
        ) {
            mVehicle.brake(brake);
        }
    }

    public void brake() {
        brake(brakeAmount);
    }

    public void setTurboOn() {
        for (MotorizedVehicle mVehicle : mVehicles) {
            if (mVehicle instanceof Saab95) {
                ((Saab95) mVehicle).setTurboOn();
            }
        }
    }

    public void setTurboOff() {
        for (MotorizedVehicle mVehicle : mVehicles) {
            if (mVehicle instanceof Saab95) {
                ((Saab95) mVehicle).setTurboOff();
            }
        }
    }

    public void lowerRamp() {
        for (MotorizedVehicle mVehicle : mVehicles) {
            if (mVehicle instanceof Scania) {
                ((Scania) mVehicle).lowerRamp(70);
            }
        }
    }

    public void raiseRamp() {
        for (MotorizedVehicle mVehicle : mVehicles) {
            if (mVehicle instanceof Scania) {
                ((Scania) mVehicle).raiseRamp(70);
            }
        }
    }

    public void startAll() {
        for (MotorizedVehicle mVehicle : mVehicles) {
            if(!mVehicle.isMoving()){
                mVehicle.startEngine();
            }
        }
    }

    public void stopAll() {
        for(MotorizedVehicle mVehicle : mVehicles) {
            mVehicle.stopEngine();
        }
    }
}
