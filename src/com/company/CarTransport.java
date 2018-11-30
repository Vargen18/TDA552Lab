package com.company;


import java.awt.*;
import java.awt.geom.Point2D;
import java.security.InvalidParameterException;

public abstract class CarTransport extends Truck implements Loadable<Car> {

    //TODO junit tests

    protected Cargo<Car> carCargo;
    protected Boolean rampIsDown;
    private final double maxCargoLength;

    public CarTransport(double enginePower, Color color, String modelName, Point2D.Double position, CardinalDirections.cardinalDirection direction, double length, double width, int maxNCars, double maxCargoLength) {
        super(2, enginePower, color, modelName, position, direction, length, width);
        carCargo = new Cargo(maxNCars, this.getPosition());
        rampIsDown = false;
        this.maxCargoLength = maxCargoLength;
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /*
    /**
     * Method checks if object is close enough to vehicle.
     *
     * @param cargo The object to be near the vehicle
     * @return true or false
     */ /*
    //Hardcoded 10 meters //TODO remove?
    public Boolean isCloseEnough(Car cargo) {
        double cargoX = cargo.getPosition().getX();
        double cargoY = cargo.getPosition().getY();
        double thisX = this.getPosition().getX();
        double thisY = this.getPosition().getY();

        double distance = Math.sqrt((Math.pow(2, cargoY - thisY)) + (Math.pow(2, cargoX - thisX)));
        return distance < 10;
    }*/

    /**
     * Method loads vehicle with cargo
     *
     * @param cargo the object to be loaded onto vehicle
     */
    //TODO replace isCloseEnough with same method in cargo? (Need to fix CarTransport.load().
    //TODO GeeseFoot1 can load GeeseFoot2 followed by GeeseFoot2 loading GeeseFoot1 without any errors.
    @Override
    public void load(Car cargo) {
        if (!cargo.equals(this)) {
            try {
                if (rampIsDown && cargo.getLength() <= 4 && carCargo.cargoIsCloseEnough(cargo, 10)){
                    carCargo.load(cargo);
                    cargo.setPosition(this.getPosition());
                } else {
                    if (!rampIsDown) {
                        throw new RampIsRaised();
                    }
                    if (!carCargo.cargoIsCloseEnough(cargo, 10)) {
                        throw new CargoIsNotCloseEnough();
                    }
                    if (cargo.getLength() < 4) {
                        throw new InvalidParameterException();
                    }

                }
            } catch (InvalidParameterException e) {
                System.err.println("Car is too long (max size is " + maxCargoLength + "m).");
            } catch (RampIsRaised e) {
                System.err.println("Ramp is raised.");
            } catch (CargoIsNotCloseEnough e) {
                System.err.println("Cargo is not close enough.");
            }
        } else {
            System.err.println("Can`t load with self");
        }
    }

    /**
     * Method unloads vehicle
     *
     * @return unloaded object in order of first in, last out
     */
    //@Override //TODO Should be override, but Loadable interface does not work as intended, see TODO in Loadable.
    public void unload() {
        Car c = carCargo.unloadLast();
        switch (getDirection()) {
            case NORTH:
                c.setPosition(new Point2D.Double((c.getPosition().getX()), c.getPosition().getY() - 5));
                break;
            case EAST:
                c.setPosition(new Point2D.Double(c.getPosition().getX() - 5, c.getPosition().getY()));
                break;
            case SOUTH:
                c.setPosition(new Point2D.Double(c.getPosition().getX(), c.getPosition().getY() + 5));
                break;
            case WEST:
                c.setPosition(new Point2D.Double(c.getPosition().getX() + 5, c.getPosition().getY()));

        }
    }

    /**
     * Method lets vehicle accelerate.
     *
     * @param amount Amount is a multiplier of how much the speed increases, and is within the interval [0, 1].
     */
    @Override
    public void gas(double amount) {
        if (!isLoaded) {
            try {
                if (!rampIsDown) {
                    super.gas(amount);
                } else {
                    throw new RampIsLowered();
                }
            } catch (RampIsLowered e) {
                System.err.println("Cannot gas when ramp is lowered. ");
            }
        } else {
            System.err.println("Cannot gas when vehicle is loaded ");
        }
    }

    /**
     * Raises the ramp.
     */
    public void raiseRamp() {
        this.rampIsDown = false;
    }

    /**
     * Lowers the ramp.
     */
    public void lowerRamp() {
        try {
            if (!this.isMoving()) {//TODO Redundant?
                rampIsDown = true;
            } else {
                throw new TruckIsMoving();
            }
        } catch (TruckIsMoving e) {
            System.err.println("Cannot lower ramp while vehicle is moving.");
        }
    }


}






