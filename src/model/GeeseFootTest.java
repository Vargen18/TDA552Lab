package model;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class GeeseFootTest {

    @Test
    public void gas() {
        GeeseFoot goose1 = new GeeseFoot(new Point2D.Double(0,0), CardinalDirections.cardinalDirection.EAST);
        GeeseFoot goose2 = new GeeseFoot(new Point2D.Double(5,5), CardinalDirections.cardinalDirection.EAST);
        Gooseneck gooseneck = new Gooseneck(new Point2D.Double(3,3), CardinalDirections.cardinalDirection.WEST);

        gooseneck.lowerRamp();

        gooseneck.load(goose1);
        //goose1.gas(1);
        //System.out.println(!gooseneck.isMoving());
        //System.out.println(!goose1.isMoving());

        gooseneck.unload();
        //System.out.println(gooseneck.carCargo.getCargoList());
        assertFalse(goose1.getLoaded());

        //goose2.load(goose2);
        //System.out.println(goose2.carCargo.getCargoList());

        goose2.lowerRamp();
        goose2.load(goose1);

        assertTrue(goose2.carCargo.getCargoList().size() != 0);
        //System.out.println((goose2.carCargo.getCargoList().get(0)) == goose1);


        goose1.lowerRamp();
        goose1.load(goose2);

        assertFalse(goose1.carCargo.getCargoList().get(0) == goose2);


    }
}