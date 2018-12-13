package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Saab95 saab95 = VehicleFactory.createSaab(x, y, direction);
        addVehicle(saab95);
    }

    public void createAndAddVolvo(int x, int y, CardinalDirections.cardinalDirection direction) {
        Volvo240 volvo = VehicleFactory.createVolvo(x, y, direction);
        addVehicle(volvo);
    }

    public void createAndAddScania(int x, int y, CardinalDirections.cardinalDirection direction) {
        Scania scania = VehicleFactory.createScania(x, y, direction);
        addVehicle(scania);
    }

    public void createAndAddGooseneck(int x, int y, CardinalDirections.cardinalDirection direction) {
        Gooseneck gooseneck = VehicleFactory.createGooseneck(x, y, direction);
        addVehicle(gooseneck);
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

//TODO
    public void gasGasGas() {
        for (MotorizedVehicle mVehicle : mVehicles
        ) {
            mVehicle.gasGasGas();
            mVehicle.turnLeft();
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

    public void addCar() {
        if(mVehicles.size() >= 8) {
            System.err.println("There are too many cars. (max " + mVehicles.size() + ")");
            return;
        } else {
            int rand = new Random().nextInt(3);
            int nVehicles = mVehicles.size();
            switch (rand) {
                case 0:
                    createAndAddSaab(nVehicles * 100, 0, CardinalDirections.cardinalDirection.NORTH);
                    break;
                case 1:
                    createAndAddVolvo(nVehicles * 100, 0, CardinalDirections.cardinalDirection.NORTH);
                    break;
                case 2:
                    createAndAddScania(nVehicles * 100, 0, CardinalDirections.cardinalDirection.NORTH);
                    break;
            }
        }

    }

    public void removeCar() {
        if(mVehicles.size() > 0) {
            mVehicles.remove(mVehicles.size()-1);
        } else {
            System.err.println("No more vehicles left!");
        }

    }
}
