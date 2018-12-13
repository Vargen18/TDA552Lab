package model;

import java.awt.geom.Point2D;

public class VehicleFactory {

    static Saab95 createSaab(int x, int y, CardinalDirections.cardinalDirection direction) {
        Saab95 saab95 = new Saab95(x, y, direction);
        return saab95;
    }

    static Volvo240 createVolvo(int x, int y, CardinalDirections.cardinalDirection direction) {
        Volvo240 volvo = new Volvo240(x, y, direction);
        return volvo;
    }

    static Scania createScania(int x, int y, CardinalDirections.cardinalDirection direction) {
        Scania scania = new Scania(x, y, direction);
        return scania;
    }

    static Gooseneck createGooseneck(int x, int y, CardinalDirections.cardinalDirection direction) {
        Gooseneck gooseneck = new Gooseneck(new Point2D.Double(x, y), direction);
        return gooseneck;
    }

}
