package org.whitfie.exeptions;

public class NullParametersExeption extends Exception {

    public NullParametersExeption() {
        super();
    }

    public NullParametersExeption(String message) {
        super(message);
    }
}
