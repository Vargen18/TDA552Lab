package model;

import java.awt.*;
import java.awt.geom.Point2D;

public class StenaSuperfastX extends CarFerry{

    public StenaSuperfastX(Point2D.Double position, CardinalDirections.cardinalDirection direction) {
        super(2, 5000, Color.ORANGE, "Stena Superfast X", position, direction, 16, 2.6, 8, 4, 4);
    }


    public double speedFactor() {
        return getEnginePower() * 0.001;
    }

}
