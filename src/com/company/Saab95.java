package com.company;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * The class represents a car of model Saab95.
 *
 * @see Car
 */
public class Saab95 extends Car {

    private boolean turboOn;

    //TODO remove
    public boolean isTurboOn() {
        return turboOn;
    }

    public Saab95() {
        super(2, 125, Color.red, "Saab95", new Point2D.Double(0, 0), CardinalDirections.cardinalDirection.NORTH, 4, 2);
        turboOn = false;
        stopEngine();
    }

    public Saab95(int x, int y, CardinalDirections.cardinalDirection direction) {
        super(2, 125, Color.red, "Saab95", new Point2D.Double(x, y), direction, 4, 2);


        turboOn = false;
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Calculates the speed factor based on engine power and turbo, assuming turbo is on, otherwise only engine power.
     *
     * @return The speed factor.
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}