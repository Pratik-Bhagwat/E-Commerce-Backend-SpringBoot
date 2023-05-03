package com.pratikbhagwat.ECommerce.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String enterTheValidEmailId) {
        super(enterTheValidEmailId);
    }
}
