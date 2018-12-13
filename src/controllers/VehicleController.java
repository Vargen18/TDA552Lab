package controllers;

import javafx.application.Application;
import model.ButtonCommands;
import model.CardinalDirections;
import model.VehicleModel;
import model.ViewObserver;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import mp3App.JavaFXApplication;
import javafx.embed.swing.JFXPanel;

import java.io.File;


/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and respond in an appropriate manner by
 * modifying the model state and updating the view.
 */

public class VehicleController implements CardinalDirections, ViewObserver {

    private VehicleModel vModel;
    private MediaPlayer mediaPlayer;
    private String dejavu;
    private Media hit;
    private JavaFXApplication app;
    public VehicleController(VehicleModel vModel) {
        this.vModel = vModel;
        app = new JavaFXApplication();
        final JFXPanel fxPanel = new JFXPanel();
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
    public void gas() {
        vModel.gas();
    }

    void brake() {
        vModel.brake();
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

    void addCar() {vModel.addCar();}

    void removeCar() {vModel.removeCar();}

    @Override
    public void doStuff(String command){
        switch(command) {
            case ButtonCommands.gas:
                this.gas();
                break;
            case ButtonCommands.brake:
                this.brake();
                break;
            case ButtonCommands.lowerRamp:
                this.lowerRamp();
                break;
            case ButtonCommands.raiseRamp:
                this.raiseRamp();
                break;
            case ButtonCommands.turboOff:
                this.setTurboOff();
                break;
            case ButtonCommands.turboOn:
                this.setTurboOn();
                break;
            case ButtonCommands.startAll:
                this.startAll();
                break;
            case ButtonCommands.stopAll:
                this.stopAll();
                break;
            case ButtonCommands.gasGasGas:
                vModel.gasGasGas();
                break;
            case ButtonCommands.addCar:
                vModel.addCar();
                break;
            case ButtonCommands.removeCar:
                vModel.removeCar();
                break;
            case ButtonCommands.dejavu:
                vModel.dejevu();
                app.play();
                break;
        }
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