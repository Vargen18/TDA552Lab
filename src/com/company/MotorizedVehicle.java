package com.company;

import javax.smartcardio.Card;
import java.awt.*;
import java.awt.geom.Point2D;
import java.security.InvalidParameterException;

public abstract class MotorizedVehicle implements Movable, CardinalDirections {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name'
    protected final double width;
    protected final double length;
    protected Boolean isLoaded = false; //Tells if vehicle is loaded or not.
    /**
     * 2 dimensional point representing the position of the car, using an x and y coordinate.
     */
    private Point2D.Double position; //TODO _NOT_ supposed to be public, ONLY for testing, DO NOT FORGET!
    /**
     * An array containing cardinal directions
     *
     * @see CardinalDirections.cardinalDirection
     */
    private cardinalDirection[] directions = {cardinalDirection.NORTH, cardinalDirection.EAST, cardinalDirection.SOUTH, cardinalDirection.WEST};
    /**
     * An integer from 0 to 3 (inclusive) used as the index when getting the direction of the car.//TODO Comment.
     *
     * @see #directions
     * @see #getDirection()
     */
    private int currentDirectionIndex;


    public MotorizedVehicle(int nrDoors, double enginePower, Color color, String modelName, Point2D.Double position, CardinalDirections.cardinalDirection direction, double length, double width) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = position;
        int currentDirctionIndex;
        int currentDirectionIndex = 0;
        switch (direction) {
            case NORTH:
                currentDirectionIndex = 0;
                break;
            case EAST:
                currentDirectionIndex = 1;
                break;
            case SOUTH:
                currentDirectionIndex = 2;
                break;
            case WEST:
                currentDirectionIndex = 3;
        }
        this.currentDirectionIndex = currentDirectionIndex;
        this.length = length;
        this.width = width;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public Point2D.Double getPosition() {
        return this.position;
    }

    //Because transports need to set position of cargo.
    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    public Boolean getLoaded() {
        return isLoaded;
    }

    //Because load/unload needs to change isLoaded.
    public void setLoaded(Boolean loaded) {
        isLoaded = loaded;
    }

    /**
     * Checks if vehicle is moving.
     *
     * @return Returns True or False.
     */
    public Boolean isMoving() {
        return (getCurrentSpeed() != 0);
    }

    /**
     * Returns the cardinal direction the car is currently facing.
     *
     * @return CardinalDirections
     */
    public CardinalDirections.cardinalDirection getDirection() {
        return directions[this.currentDirectionIndex];
    }

    /**
     * Starts the engine
     */
    //Wont start if vehicle is loaded (because starting engine gives initial speed).
    public void startEngine() {
        if (!this.isLoaded) {
            currentSpeed = 0.1;
        } else {
            System.err.println(" Can´t start engine since vehicle is loaded. ");
        }

    }

    /**
     * Sets the current speed to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    /**
     * Increases speed based on engine power, turbo, trim and amount.
     *
     * @param amount is the multiplier for how much the speed increases.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower) {
            currentSpeed = enginePower;
        }
    }

    /**
     * Decreases speed based on engine power, turbo, trim and amount.
     *
     * @param amount is the multiplier for how much the speed decreases.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    /**
     * Changes direction of the car by 90° degrees. (for example: North to east)
     */
    public void turnRight() {
        if (!this.isLoaded) {
            currentDirectionIndex = (currentDirectionIndex + 1) % 4;
        } else {
            System.err.println(" Can´t turn since vehicle is loaded. ");
        }

    }

    /**
     * Changes direction of the car by -90° degrees. (for example: North to west)
     */
    public void turnLeft() {
        if (!this.isLoaded) {
            if (--currentDirectionIndex < 0) {
                currentDirectionIndex = 3;
            }
        } else {
            System.err.println(" Can´t turn since vehicle is loaded. ");
        }
    }

    /**
     * Changes the position of the car based on its direction (one of the cardinal directions) and its speed.
     */
    public void move() {
        switch (getDirection()) {
            case NORTH:
                position.setLocation(position.getX(), position.getY() + currentSpeed);
                break;
            case EAST:
                position.setLocation(position.getX() + currentSpeed, position.getY());
                break;
            case SOUTH:
                position.setLocation(position.getX(), position.getY() - currentSpeed);
                break;
            case WEST:
                position.setLocation(position.getX() - currentSpeed, position.getY());
        }
    }

    /**
     * Increments the speed of the car.
     *
     * @param amount Amount is a multiplier of how much the speed increases, and is within the interval [0, 1].
     * @see #incrementSpeed(double)
     */
    public void gas(double amount) {
        if (!this.isLoaded) {
            try {
                if (!(amount <= 1 && amount >= 0)) {
                    throw new InvalidParameterException();
                } else {
                    incrementSpeed(amount);
                }
            } catch (InvalidParameterException e) {
                System.err.println("Gas only accepts floats between 0 and 1.");
            }
        } else {
            System.err.println(" Can´t gas since vehicle is loaded. ");
        }
    }

    /**
     * Increments the speed of the car. Amount is a multiplier of how much the speed increases, and is within the interval [0, 1].
     *
     * @param amount
     * @see #decrementSpeed(double)
     */
    public void brake(double amount) {
        try {
            if (!(amount <= 1 && amount >= 0)) {
                throw new InvalidParameterException();
            } else {
                decrementSpeed(amount);
            }
        } catch (InvalidParameterException e) {
            System.err.println("Break only accepts floats between 0 and 1.");
        }
    }

    public String getModelName(){
        return this.modelName;
    }

    public void flipDirection() {
        currentDirectionIndex = (currentDirectionIndex + 2) % 4;
    }

}
