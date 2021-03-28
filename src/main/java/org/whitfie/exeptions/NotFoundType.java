package org.whitfie.exeptions;

public class NotFoundType extends Exception {
    public NotFoundType() {
    }

    public NotFoundType(String message) {
        super(message);
    }
}
