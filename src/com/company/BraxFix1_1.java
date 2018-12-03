package com.company;

public class BraxFix1_1 {
    /*
     * (MotorizedVehicle)
     *       Gave MotorizedVehicle the isLoaded variable, as well as getters/setters.
     *       Changed following methods to take isLoaded into account. (Simple error message)
     *           turnRight()/turnLeft()
     *           startEngine()
     *           gas()
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
     * (Cargo)
     *       Changed load so that an already loaded vehicle cannot be loaded (Simple error message)
     *
     *  TODO: Note: Should CarFerry have own gas() method? (currently using MotorizedVehicle.gas())
     *
     * */
}
