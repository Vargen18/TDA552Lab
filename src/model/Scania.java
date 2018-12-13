package model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.security.InvalidParameterException;

public class Scania extends Truck {


    private double rampAngle;

    Scania(Point2D.Double position, CardinalDirections.cardinalDirection direction) {
        super(2, 200, Color.black, "Scania", position, direction, 8, 2.6);
        rampAngle = 0;
    }

    Scania(int x, int y, CardinalDirections.cardinalDirection direction) {
        super(2, 200, Color.black, "Scania", new Point2D.Double(x, y), direction, 8, 2.6);
        rampAngle = 0;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.005;
    }

    /**
     * Raises the loading ramp.
     *
     * @param angle The angle by which the ramp is raised and should be a positive number
     */
    public void raiseRamp(double angle) {
        try {
            if (angle <= 0) {
                throw new InvalidParameterException();
            } else if (!this.isMoving()) {
                rampAngle = rampAngle + angle;
                if (rampAngle > 70) {
                    rampAngle = 70;
                    System.err.println("Angle of the ramp cannot exceed 70 degrees, therefore ramp was lowered back to 70 degrees.");
                }
            } else {
                System.err.println("Cannot raise ramp while vehicle is moving! ");
            }
        } catch (InvalidParameterException e) {
            System.err.println("Cannot raise ramp with negative value");
        }
    }

    /**
     * Lowers the loading ramp by the given angle.
     *
     * @param angle The angle by which the ramp is lowered and should be a positive number
     */
    public void lowerRamp(double angle) {
        try {
            if (angle <= 0) {
                throw new InvalidParameterException();
            } else if (!this.isMoving()) {
                rampAngle = rampAngle - angle;
                if (rampAngle < 0) {
                    rampAngle = 0;
                    System.err.println("Angle of the ramp cannot fall below 0 degrees, therefore ramp was raised back to 0 degrees.");
                }
            } else {
                System.err.println("Cannot raise ramp when vehicle is moving.");
            }
        } catch (InvalidParameterException e) {
            System.err.println("Cannot lower ramp with negative value");
        }
    }

    /**
     * Lets vehicle accelerate.
     *
     * @param amount Amount is a multiplier of how much the speed increases, and is within the interval [0, 1].
     */
    @Override
    public void gas(double amount) {
        if (!this.isLoaded) {
            try {
                if (rampAngle == 0) {
                    super.gas(amount);
                } else {
                    throw new RampIsRaised();
                }
            } catch (RampIsRaised e) {
                System.err.println(" Cannot gas when ramp is raised ");
            }
        } else {
            System.err.println(" Cannot gas when vehicle is loaded ");
        }

    }
    //TODO Remove after testing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public double getRampAngle() {
        return rampAngle;
    }

    public void setRampAngle(double rampAngle) {
        this.rampAngle = rampAngle;
    }
}

