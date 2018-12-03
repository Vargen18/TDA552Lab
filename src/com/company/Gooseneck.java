package com.company;

import java.awt.*;
import java.awt.geom.Point2D;

public class Gooseneck extends CarTransport {

    public Gooseneck(Point2D.Double position, CardinalDirections.cardinalDirection direction) {
        super(200, Color.RED, "8.5' X 53' Heavy Duty Gooseneck", position, direction, 16, 2.6, 8, 4);
    }

    public double speedFactor() {
        return getEnginePower() * 0.005;
    }

}
