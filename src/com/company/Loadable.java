package com.company;

public interface Loadable<C> {
    public void load(C cargo);
    //public C unloadLast(); //TODO Intended implementation: Loadables have to implement the method "public C unloadLast()" OR the method "public C unloadLast(int i)".
    //TODO Can be achieved with "either"?

    static class CargoIsNotCloseEnough extends Exception {

    }
}
