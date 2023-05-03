package com.pratikbhagwat.ECommerce.exception;

public class SellerAlreadyExistsException extends Exception {
    public SellerAlreadyExistsException(String sellerAlreadyExists) {
        super(sellerAlreadyExists);
    }
}
