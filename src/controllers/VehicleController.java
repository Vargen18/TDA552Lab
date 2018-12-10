package controllers;

import com.company.*;

import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and respond in an appropriate manner by
 * modifying the model state and updating the view.
 */

public class VehicleController implements CardinalDirections {

    // The frame that represents this instance View of the MVC pattern
    VehicleView frame = new VehicleView("CarSim 1.0", this);

    private VehicleModel vModel;

    public VehicleController(VehicleModel vModel) {
        this.vModel = vModel;
    }

    public void moveAllVehicles(){
        vModel.moveAllVehicles();
    }

    /*private void drawCar(Car car, int i){
        int x = (int) Math.round(car.getPosition().getX());
        int y = (int) Math.round(car.getPosition().getY());
        frame.drawPanel.moveit(x, y, cars.get(i).getModelName(), i);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
    }*/

    // Calls the gas method for each car once
    void gas(int amount) {
        vModel.gas(amount);
    }

    void brake(int amount) {
        vModel.brake(amount);
    }

    void setTurboOn() {
        vModel.setTurboOn();
    }

    void setTurboOff() {
        vModel.setTurboOff();
    }

    void lowerRamp() {
        vModel.lowerRamp();
    }

    void raiseRamp() {
        vModel.raiseRamp();
    }

    void startAll() {
        vModel.startAll();
    }

    void stopAll() {
        vModel.stopAll();
    }

    public void createAndAddSaab(int x, int y, CardinalDirections.cardinalDirection direction) {
        vModel.createAndAddSaab(x, y, direction);
    }

    public void createAndAddVolvo(int x, int y, CardinalDirections.cardinalDirection direction) {
        vModel.createAndAddVolvo(x, y, direction);
    }

    public void createAndAddScania(int x, int y, CardinalDirections.cardinalDirection direction) {
        vModel.createAndAddScania(x, y, direction);
    }
}