package com.pratikbhagwat.ECommerce.service;

import com.pratikbhagwat.ECommerce.Dto.Request.OrderRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.OrderResponseDto;
import com.pratikbhagwat.ECommerce.exception.OrderDoesNotExistsException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;

import java.util.List;

public interface OrdersService {
    OrderResponseDto placeDirectOrder(OrderRequestDto orderRequestDto) throws Exception;

    List<OrderResponseDto> getAllOrdersOfAUser(int userId) throws UserNotFoundException;

    List<OrderResponseDto> getRecentFiveOrdersOfUser(int userId);

    String deleteOrderOfAUser(int orderId) throws OrderDoesNotExistsException;

    OrderResponseDto getTheHighestValueOrderEver();
}
