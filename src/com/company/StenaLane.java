package com.company;

import java.awt.*;
import java.awt.geom.Point2D;

public class StenaLane extends CarFerry {

    public StenaLane(int nrDoors, Point2D.Double position, cardinalDirection direction, int maxNCars) {
        super(2, 50, Color.ORANGE, "Stena Superfast X", position, direction, 16, 2.6, 8, 4, 4);
    }


    public double speedFactor() {
        return getEnginePower() * 0.001;
    }

}
