package com.company;

public class BraxFix1_1 {
    /*
     * (MotorizedVehicle)
     *       Gave MotorizedVehicle the isLoaded variable, as well as getters/setters.
     *       Changed following methods to take isLoaded into account. (Simple error message)
     *           turnRight()/turnLeft()
     *           startEngine()
     *           gas()
     *                              TODO: Note: Should move()/brake() be changed in same way? (Probably not break, maybe move for safety reasons) Samuels respons: Behövs ej, då gas är den enda publika
     *
     * (Scania)
     *       Changed following methods to take isLoaded into account. (Simple error message)
     *           gas()
     *
     *                              TODO: Note: Should we remove setters (Ramp eg.) when we are done testing? ... Yep.
     *
     * (CarTransport)
     *       Changed load so that carTransport cant load with self (using equals(this)) (Simple error message)
     *       Changed gas() so that carTransport cant gas when isLoaded
     *
     *                              TODO: Note: Should we remove isCloseEnough and use the same method in cargo instead? (cargo position = transport position, so shouldn't matter...) - Fixed till Point2D's distance
     *                              TODO: Note: Also use Point2D distance() method instead of calculating by ourselves? - Se ovan
     *
     * (Cargo)
     *       Changed load so that an already loaded vehicle cannot be loaded (Simple error message)
     *
     *  TODO: Note: Should CarFerry have own gas() method? (currently using MotorizedVehicle.gas())
     *  TODO: Note: No vehicle should be able to carry CarFerries... Let Cargo parametrised type extend Car instead of MotorizedVehicle?
     *
     * */
}
