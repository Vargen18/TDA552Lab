package com.company;

import java.awt.*;
import java.awt.geom.Point2D;

public class GeeseFoot extends CarTransport{

    public GeeseFoot(Point2D.Double position, CardinalDirections.cardinalDirection direction) {
        super(199, Color.BLUE, "5.5' X 33' Light Duty GeeseFoot", position, direction, 4, 2.6, 1, 4);
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
