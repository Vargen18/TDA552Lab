package com.company;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CarTransportTest {

    @Test
    public void gas() {
        Gooseneck goose = new Gooseneck(new Point2D.Double(1,1), CardinalDirections.cardinalDirection.NORTH);

        goose.lowerRamp();
        goose.gas(1);
        assertEquals(0, goose.getCurrentSpeed(), 0);

        goose.raiseRamp();
        goose.gas(1);
        assertEquals(false, goose.getCurrentSpeed() == 0);

        goose.lowerRamp();
        assertEquals(false, goose.rampIsDown);

    }

    @Test
    public void raiseRamp() {
        Gooseneck goose = new Gooseneck(new Point2D.Double(1,1), CardinalDirections.cardinalDirection.NORTH);

        goose.lowerRamp();
        assertEquals(true, goose.rampIsDown);

        goose.raiseRamp();

        assertEquals(false, goose.rampIsDown);


    }

    @Test
    public void lowerRamp() {
        Gooseneck goose = new Gooseneck(new Point2D.Double(1,1), CardinalDirections.cardinalDirection.NORTH);

        assertEquals(false, goose.rampIsDown);

        goose.lowerRamp();

        assertEquals(true, goose.rampIsDown);

    }
}