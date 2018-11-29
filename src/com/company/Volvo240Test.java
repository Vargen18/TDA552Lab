package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {

    @Test
    public void speedFactor() {
        Volvo240 volvo240 = new Volvo240();
        double expectedDouble = volvo240.getEnginePower()/100  * 1.25;
        assertEquals(expectedDouble, volvo240.speedFactor(), 0);
        /*void assertTrue((expectedDouble == speedFactor));*/
    }
}