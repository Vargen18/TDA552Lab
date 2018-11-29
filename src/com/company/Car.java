package com.company;

import java.awt.*;
import java.awt.geom.Point2D;
import java.security.InvalidParameterException;

/**
 * An abstract class representing a general car.
 **/
public abstract class Car extends MotorizedVehicle {

    public Car(int nrDoors, double enginePower, Color color, String modelName, Point2D.Double position, cardinalDirection direction, double length, double width) {
        super(nrDoors, enginePower, color, modelName, position, direction, length, width);
    }

}
