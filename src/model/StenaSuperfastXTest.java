package model;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class StenaSuperfastXTest {

    @Test
    public void load() {
        StenaSuperfastX stena = new StenaSuperfastX(new Point2D.Double(0,0), CardinalDirections.cardinalDirection.NORTH);
        for (int i = 0; i < 33; i ++){
            Saab95 saab = new Saab95();
            stena.load(saab);
        }
        Scania scania = new Scania(0,0, CardinalDirections.cardinalDirection.NORTH);
        stena.load(scania);
        assertTrue(!scania.isLoaded);
    }

    @Test
    public void load1() {
    }

    @Test
    public void unload() {
    }

    @Test
    public void isMoving() {
    }

    @Test
    public void getDirection() {
    }

    @Test
    public void startEngine() {
    }

    @Test
    public void stopEngine() {
    }

    @Test
    public void flipDirection() {
    }
}