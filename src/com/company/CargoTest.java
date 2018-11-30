package com.company;

import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CargoTest {

    Gooseneck goose = new Gooseneck(new Point2D.Double(1, 1), MotorizedVehicle.cardinalDirection.NORTH);
    Saab95 saab = new Saab95();


    @Test
    public void load() {

        Gooseneck goose = new Gooseneck(new Point2D.Double(1, 1), MotorizedVehicle.cardinalDirection.NORTH);
        Saab95 saab = new Saab95();

        goose.lowerRamp();
        goose.load(saab);
        assertEquals(saab, goose.carCargo.getCargoList().get(0));

        System.out.println(goose.carCargo.getCargoList());

/*        for(int i = 0; i < 100; i++) {
            goose.carCargo.load(new Saab95());
        }*/

    }

    @Test
    public void unloadLast() {
        Gooseneck goose = new Gooseneck(new Point2D.Double(1, 1), MotorizedVehicle.cardinalDirection.NORTH);
        Saab95 saab = new Saab95();
        Saab95 saab2 = new Saab95();

        goose.lowerRamp();
        goose.load(saab);
        goose.load(saab2);
        assertEquals(saab2, goose.carCargo.getCargoList().get(0));

        goose.unload();

        assertEquals(false, goose.getPosition() == saab2.getPosition());
        //assertEquals(new Point2D.Double(1,1), saab.getPosition());
    }

    @Test
    public void unloadFirst() {
        //StenaSuperfastX stean = new StenaSuperfastX(2, );
        Saab95 saab = new Saab95();
        Saab95 saab2 = new Saab95();

        goose.lowerRamp();
        goose.load(saab);
        goose.load(saab2);
        assertEquals(saab2, goose.carCargo.getCargoList().get(0));

        goose.unload();

        assertEquals(false, goose.getPosition() == saab2.getPosition());
        //assertEquals(new Point2D.Double(1,1), saab.getPosition());
    }

    @Test
    public void cargoIsCloseEnough() {
        Point2D.Double point = new Point2D.Double(3, -12848);
        Saab95 saaab = new Saab95();
        saaab.setPosition(point);

        Gooseneck goose = new Gooseneck(new Point.Double(1, 1247), MotorizedVehicle.cardinalDirection.NORTH);
        double cargoX = goose.getPosition().getX();
        double cargoY = goose.getPosition().getY();
        double thisX = saaab.getPosition().getX();
        double thisY = saaab.getPosition().getY();

        double distance = Math.sqrt((Math.pow(cargoY - thisY, 2)) + (Math.pow(cargoX - thisX, 2)));
        //double distance = Point2D.Double.distance(cargo.getPosition().getX(), cargo.getPosition().getY(), this.position.getX(), this.position.getY());
        double distance2 = saaab.getPosition().distance(goose.getPosition());
        assertEquals(distance, distance2, 0);
    }

    //Både vår och Point2D's inbyggda metod "distance" funkar :)

}