package model;

public class VehicleFactory {

    public static Saab95 createSaab(int x, int y, CardinalDirections.cardinalDirection direction) {
        Saab95 saab95 = new Saab95(x, y, direction);
        return saab95;
    }

    public static Volvo240 createVolvo(int x, int y, CardinalDirections.cardinalDirection direction) {
        Volvo240 volvo = new Volvo240(x, y, direction);
        return volvo;
    }

    public static Scania createScania(int x, int y, CardinalDirections.cardinalDirection direction) {
        Scania scania = new Scania(x, y, direction);
        return scania;
    }

}
