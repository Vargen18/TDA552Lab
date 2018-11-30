package com.company;

public interface Loadable<C> {
    void load(C cargo);
    //public C unloadLast(); //TODO Intended implementation: Loadables have to implement the method "public C unloadLast()" OR the method "public C unloadLast(int i)".
    //TODO Can be achieved with "either"?

    class CargoIsNotCloseEnough extends Exception {

    }


}
