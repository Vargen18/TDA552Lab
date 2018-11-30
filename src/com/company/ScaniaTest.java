package com.company;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class ScaniaTest {

    Scania scania1 = new Scania(new Point2D.Double(0,0), CardinalDirections.cardinalDirection.NORTH);

    @org.junit.Test
    public void gas() {
        scania1.setRampAngle(20);
        scania1.gas(1);
        assertEquals(false, scania1.isMoving());

        scania1.lowerRamp(1000);
        scania1.gas(1);
        assertEquals(true, scania1.isMoving());
    }

    @org.junit.Test
    public void raiseRamp() {
        scania1.setRampAngle(0);
        assertEquals(0, scania1.getRampAngle(), 0);

        scania1.raiseRamp(60);
        assertEquals(60, scania1.getRampAngle(), 0);

        scania1.raiseRamp(-2);
        assertEquals(60, scania1.getRampAngle(), 0);

        scania1.raiseRamp(20);
        assertEquals(70, scania1.getRampAngle(), 0);


    }

    @org.junit.Test
    public void lowerRamp() {
        scania1.setRampAngle(0);
        assertEquals(0, scania1.getRampAngle(), 0);
        scania1.lowerRamp(60);
        assertEquals(0, scania1.getRampAngle(), 0);

        scania1.lowerRamp(-2);
        assertEquals(0, scania1.getRampAngle(), 0);

        scania1.setRampAngle(70);
        assertEquals(70, scania1.getRampAngle(), 0);
        scania1.lowerRamp(35);
        assertEquals(35, scania1.getRampAngle(), 0);

    }
}