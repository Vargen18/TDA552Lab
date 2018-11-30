package com.company;

import java.awt.*;
import java.awt.geom.Point2D;

public class StenaSuperfastX extends CarFerry{

    public StenaSuperfastX(int nrDoors, Point2D.Double position, CardinalDirections.cardinalDirection direction, int maxNCars) {
        super(2, 5000, Color.ORANGE, "Stena Superfast X", position, direction, 16, 2.6, 8, 4, 4);
    }


    public double speedFactor() {
        return getEnginePower() * 0.001;
    }

    public void load(Car cargo){
        //load(random.rand(4), cargo); //TODO Implement a load(Car cargo) that loads a Car into the lane with the fewest cars (shortest length of carCargo).
    }
}
