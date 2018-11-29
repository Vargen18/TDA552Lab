package com.company;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Truck extends Car { //implements Loadable

    public Truck(int nrDoors, double enginePower, Color color, String modelName, Point2D.Double position, cardinalDirection direction, double length, double width) {
        super(nrDoors, enginePower, color, modelName, position, direction, length, width);
    }

    protected class RampIsRaised extends Exception {

    }

    protected class RampIsLowered extends Exception {

    }

    protected class TruckIsMoving extends Exception {

    }

}
