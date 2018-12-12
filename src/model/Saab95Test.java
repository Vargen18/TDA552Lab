package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {

    @Test
    public void setTurboOn() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        assertEquals(true, saab95.isTurboOn());
    }

    @Test
    public void setTurboOff() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        saab95.setTurboOff();
        assertEquals(true, !saab95.isTurboOn());
    }

    @Test
    public void speedFactor() {
        Saab95 saab95 = new Saab95();
        double expectedDouble = saab95.getEnginePower()/100;
        assertEquals(expectedDouble, saab95.speedFactor(), 0);
        /*void assertTrue((expectedDouble == speedFactor));*/

        saab95.setTurboOn();
        double expectedDoubleTurboOn = (saab95.getEnginePower()/100) * 1.3;
        assertEquals(expectedDoubleTurboOn, saab95.speedFactor(), 0);
    }
}