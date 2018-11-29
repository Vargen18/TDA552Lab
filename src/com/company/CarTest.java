package com.company;

import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class CarTest {

    @org.junit.Test
    public void speedFactor() {
        Saab95 saab95 = new Saab95();
        double expectedDouble = saab95.getEnginePower() / 100;
        assertEquals(expectedDouble, saab95.speedFactor(), 0);
        /*void assertTrue((expectedDouble == speedFactor));*/

    }

    @org.junit.Test
    public void incrementSpeed() {
        /*Saab95 saab95 = new Saab95();
        saab95.startEngine();
        double startSpeed = saab95.getCurrentSpeed();
        double amount = 1;
        saab95.incrementSpeed(amount);
        assertEquals(startSpeed + amount * saab95.getEnginePower() / 100, saab95.getCurrentSpeed(), 0);*/
    }

    @org.junit.Test
    public void decrementSpeed() {
/*        Saab95 saab95 = new Saab95();
        saab95.startEngine();
        saab95.gas(1);
        double startSpeed = saab95.getCurrentSpeed();
        double amount = 1;
        saab95.decrementSpeed(amount);
        assertEquals(0.1, saab95.getCurrentSpeed(), 0.000001); //TODO Hårdkodat eller såhär? -> startSpeed - amount * saab95.getEnginePower() / 100*/
    }

    @org.junit.Test
    public void turnRight() {
        Saab95 saab95 = new Saab95();
        Car.cardinalDirection originalDirection = saab95.getDirection();
        saab95.turnRight();
        assertEquals(Car.cardinalDirection.EAST, saab95.getDirection());

        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        assertEquals(originalDirection, saab95.getDirection());

        saab95.turnRight();
        saab95.turnLeft();
        assertEquals(originalDirection, saab95.getDirection());
    }

    @org.junit.Test
    public void turnLeft() {
        Saab95 saab95 = new Saab95();
        Car.cardinalDirection originalDirection = saab95.getDirection();
        saab95.turnLeft();
        assertEquals(Car.cardinalDirection.WEST, saab95.getDirection());

        saab95.turnLeft();
        saab95.turnLeft();
        saab95.turnLeft();
        assertEquals(originalDirection, saab95.getDirection());

        saab95.turnLeft();
        saab95.turnRight();
        assertEquals(originalDirection, saab95.getDirection());
    }


    @org.junit.Test
    public void move() {
        Saab95 saab95 = new Saab95();
        saab95.startEngine();
        double startSpeed = saab95.getCurrentSpeed();
        double amount = 1;
        saab95.gas(amount);
        assertEquals(startSpeed + amount * saab95.getEnginePower() / 100, saab95.getCurrentSpeed(), 0); //Just making sure the speed is correct before worrying about move.
        saab95.move();
        Point2D.Double firstTestPoint = new Point2D.Double();
        firstTestPoint.setLocation(0, saab95.getCurrentSpeed()); //secondtestpt.... :) :D :P :S
        assertEquals(firstTestPoint, saab95.getPosition());
    }

    @org.junit.Test
    public void gas() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        double initialSpeed = volvo240.getCurrentSpeed();
        volvo240.gas(1.2);
        volvo240.gas(-1);

        volvo240.gas(0);
        assertEquals(initialSpeed, volvo240.getCurrentSpeed(), 0);

        volvo240.gas(1);
        assertEquals(initialSpeed + volvo240.speedFactor(), volvo240.getCurrentSpeed(), 0);

        volvo240.gas(0.5);
        assertEquals(initialSpeed + volvo240.speedFactor() * 1.5, volvo240.getCurrentSpeed(), 0);

    }

    @org.junit.Test
    public void brake() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        for (int i = 0; i < 4; i++) {
            volvo240.gas(1);
        }
        double initialSpeed = volvo240.getCurrentSpeed();
        volvo240.brake(1.2);
        volvo240.brake(-1);
        volvo240.brake(0);
        assertEquals(initialSpeed, volvo240.getCurrentSpeed(), 0);

        volvo240.brake(1);
        assertEquals(initialSpeed - volvo240.speedFactor(), volvo240.getCurrentSpeed(), 0);

        volvo240.brake(0.5);
        assertEquals(initialSpeed - volvo240.speedFactor() * 1.5, volvo240.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void brakeTransport() {
        Volvo240 volvo240 = new Volvo240();
        Gooseneck gooseneck = new Gooseneck(new Point2D.Double(0,0), MotorizedVehicle.cardinalDirection.EAST);
        gooseneck.load(volvo240);

        gooseneck.lowerRamp();
        System.out.println(gooseneck.rampIsDown);
        gooseneck.load(volvo240);

        gooseneck.raiseRamp();
        gooseneck.gas(1);
        System.out.println(gooseneck.getCurrentSpeed());

        gooseneck.move();
        System.out.println(gooseneck.getPosition());

        volvo240.brake(1);

        assertEquals(2.0, gooseneck.getCurrentSpeed(), 0);

        volvo240.gas(1);
        assertEquals(0, volvo240.getCurrentSpeed(), 0);
    }
}