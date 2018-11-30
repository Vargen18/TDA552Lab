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
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 17;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0, 0, cardinalDirection.NORTH));
        cc.cars.add(new Saab95(100, 0, cardinalDirection.NORTH));
        cc.cars.add(new Scania(200, 0, cardinalDirection.NORTH));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            moveAllCars();
        }
    }

    private void moveAllCars(){
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