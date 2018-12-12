package model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Cargo<T extends Car> implements Loadable<T> {

    /*public class CargoIsFull extends Exception{

    }*/

    /*private static final Exception CargoIsFull = ;

    public <T extends Exception> void throwIt(T t) throws T {

        throw new Exceptions.CargoIsFull();}

    public void catchIt() {
        try {
            throwIt(new Exception()); // CargoIsFull();
        } catch (Exception e) {

        }
    }*/

    private ArrayList<T> cargoList = new ArrayList<>();
    private int maxNVehicles;
    private Point2D.Double position;

    public Cargo(int i, Point2D.Double position) {
        this.position = position;
        this.maxNVehicles = i;
    }

    //T cargoA = new Cargo<>();

    /**
     * Method loads vehicle with object
     *
     * @param cargo the object to be loaded onto vehicle
     */
    public void load(T cargo) {
        if (cargoList.size() < maxNVehicles && !cargo.getLoaded()) {
            this.cargoList.add(cargo);
            cargo.setLoaded(true);
        } else if (cargoList.size() > maxNVehicles) {
            try {
                throw new CargoIsFull();
            }
            catch (CargoIsFull e){
                System.err.println(e.getErrMessage());
                }
        } else if (cargo.getLoaded()) {
            System.err.println(" Vehicle is already loaded! ");
        }
    }

    /**
     * Method unloads vehicle
     *
     * @return unloaded object in order of first in, last out
     */
    public T unloadLast() {
        cargoList.get(cargoList.size()-1).setLoaded(false);
        return cargoList.remove(cargoList.size() - 1);
    }

    public T unloadFirst() {
        cargoList.get(0).setLoaded(false);
        return cargoList.remove(0);
    }

    /**
     * Creates a list.
     *
     * @return list
     */
    public List<T> getCargoList() {
        return cargoList;
    }

    public Boolean cargoIsCloseEnough(T cargo, int maxDistance) {
        double cargoX = cargo.getPosition().getX();
        double cargoY = cargo.getPosition().getY();
        double thisX = this.position.getX();
        double thisY = this.position.getY();

        //double distance = Math.sqrt((Math.pow(2, cargoY - thisY)) + (Math.pow(2, cargoX - thisX)));
        //double distance = Point2D.Double.distance(cargo.getPosition().getX(), cargo.getPosition().getY(), this.position.getX(), this.position.getY());
        double distance = this.position.distance(cargo.getPosition());
        return distance < maxDistance;
    }
}
