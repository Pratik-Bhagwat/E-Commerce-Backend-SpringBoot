package com.pratikbhagwat.ECommerce.service;

import com.pratikbhagwat.ECommerce.Dto.Request.CheckOutCartRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.CartResponseDto;
import com.pratikbhagwat.ECommerce.Dto.Response.OrderResponseDto;
import com.pratikbhagwat.ECommerce.entity.Item;
import com.pratikbhagwat.ECommerce.exception.InvalidCardException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;

public interface CartService {
    CartResponseDto addToCart(int userId, Item savedItem);

    OrderResponseDto checkOutCart(CheckOutCartRequestDto checkOutCartRequestDto) throws Exception;

    String removeFromCart(int userId, int itemId) throws UserNotFoundException;
}
