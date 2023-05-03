package com.pratikbhagwat.ECommerce.exception;

public class NoUserFoundWithThisEmailException extends Exception {
    public NoUserFoundWithThisEmailException(String s) {
        super(s);
    }
}
