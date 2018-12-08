package controllers;

import com.company.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and respond in an appropriate manner by
 * modifying the model state and updating the view.
 */

public class CarController implements CardinalDirections {

    // The frame that represents this instance View of the MVC pattern
    CarView frame = new CarView("CarSim 1.0", this);
    // A list of cars, modify if needed
    public ArrayList<Car> cars = new ArrayList<>();


    public void moveAllCars(){
        int i = 0;
        for (Car car : cars) {
            moveAndDrawCar(car, i);
            i++;
        }
    }

    private void moveAndDrawCar(Car car, int i){
        moveCar(car);
        drawCar(car, i);
    }

    private void moveCar(Car car){
        car.move();
        if (car.getPosition().getX() > 800 - 100 || car.getPosition().getY() > (800 - 240 - 60) || car.getPosition().getX() < 0 || car.getPosition().getY() < 0) {
            car.flipDirection();
        }
    }

    private void drawCar(Car car, int i){
        int x = (int) Math.round(car.getPosition().getX());
        int y = (int) Math.round(car.getPosition().getY());
        frame.drawPanel.moveit(x, y, cars.get(i).getModelName(), i);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                car.setCurrentSpeed(car.getCurrentSpeed()*2);
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void lowerRamp() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerRamp(70);
            }
        }
    }

    void raiseRamp() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseRamp(70);
            }
        }
    }

    void startAll() {
        for (Car car : cars) {
            if(!car.isMoving()){
                car.startEngine();
            }
        }
    }

    void stopAll() {
       for(Car car : cars) {
           car.stopEngine();
       }
    }
}