package model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class CarFerry extends MotorizedVehicle implements Loadable<Car>{

    private ArrayList<Cargo<Car>> lanes;
    private final int maxNCarsPerLane;
    private final double maxCargoLength;

    public CarFerry(int nrDoors, double enginePower, Color color, String modelName, Point2D.Double position, CardinalDirections.cardinalDirection direction,
                    double length, double width, int maxNCarsPerLane, int nLanes, double maxCargoLength) {
        super(nrDoors, enginePower, Color.CYAN, modelName, position, direction, length, width);
        this.lanes = new ArrayList<>(nLanes);
        this.maxNCarsPerLane = maxNCarsPerLane;
        for (int i = 0; i < nLanes; i++) {
            this.lanes.add(new Cargo<>(maxNCarsPerLane, position));
        }
        this.maxCargoLength = maxCargoLength;
    }

    private class AllLanesFullException extends Exception{
        private String errMessage = "All lanes are full! There are " + lanes.size() + " lanes, each holding " + maxNCarsPerLane + " cars. ";
        public String getErrMessage(){
            return errMessage;
        }
    }

    /**
     * Loads ferry with cargo
     *
     * @param laneIndex index of lane to load cars
     * @param car       object to be loaded
     */
    private void load(int laneIndex, Car car) {
        try {
            if (!laneIsFull(laneIndex) && lanes.get(laneIndex).cargoIsCloseEnough(car, 25)) {
                lanes.get(laneIndex).load(car);
                car.setPosition(this.getPosition());
            } else {
                if (!lanes.get(laneIndex).cargoIsCloseEnough(car, 25)) {
                    throw new Loadable.CargoIsNotCloseEnough();
                }
                if (car.getLength() < 4) {
                    throw new InvalidParameterException();
                }

            }
        } catch (InvalidParameterException e) {
            System.err.println("Car is too long (max size is " + maxCargoLength + "m).");
        } catch (Loadable.CargoIsNotCloseEnough e) {
            System.err.println("Cargo is not close enough.");
        }
    }

    public void load(Car cargo){
        try {
            boolean cargoLoaded = false;
            for (int i = 0; i < lanes.size(); i++) {
                if (!laneIsFull(i)) {
                    load(i, cargo);
                    cargoLoaded = true;
                    break;
                }
            }
            if (!cargoLoaded){
                throw new AllLanesFullException();
            }
        } catch (AllLanesFullException e) {
            System.err.println(e.getErrMessage());
        }
    }

    private Boolean laneIsFull(int i){
        return lanes.get(i).getCargoList().size() >= maxNCarsPerLane;
    }

    /**
     * Method unloads vehicle
     *
     * @param laneIndex index of lane to load cars
     */
    //@Override //TODO Should be override, but Loable interface does not work as intended, see TODO in Loadable.
    public void unload(int laneIndex) {
        Car c = lanes.get(laneIndex).unloadFirst();

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
}
