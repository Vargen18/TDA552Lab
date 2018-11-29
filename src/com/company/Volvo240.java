package com.company;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * The class represents a car of model Volvo240.
 *
 * @see Car
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", new Point2D.Double(0, 0), cardinalDirection.NORTH, 4, 2);
        stopEngine();
    }

    public Volvo240(int x, int y, cardinalDirection direction) {
        super(4, 100, Color.black, "Volvo240", new Point2D.Double(x, y), direction, 4, 2);
        stopEngine();
    }

    /**
     * Calculates the speed factor using the trim factor and engine power.
     *
     * @return The speed factor.
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}