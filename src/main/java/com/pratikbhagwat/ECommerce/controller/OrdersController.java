package com.pratikbhagwat.ECommerce.controller;

import com.pratikbhagwat.ECommerce.Dto.Request.OrderRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.OrderResponseDto;
import com.pratikbhagwat.ECommerce.exception.OrderDoesNotExistsException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;
import com.pratikbhagwat.ECommerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @PostMapping("/place")
    public OrderResponseDto placeDirectOrder(@RequestBody OrderRequestDto orderRequestDto) throws Exception {
        return ordersService.placeDirectOrder(orderRequestDto);
    }
    @GetMapping("/get-all/{userId}")
    public List<OrderResponseDto> getAllOrdersOfAUser(@PathVariable("userId") int userId) throws UserNotFoundException {
        return ordersService.getAllOrdersOfAUser(userId);
    }
    @GetMapping("/get-recent/{userId}")
    public List<OrderResponseDto> getRecentFiveOrdersOfUser(@PathVariable("userId") int userId){
        return ordersService.getRecentFiveOrdersOfUser(userId);
    }
    @DeleteMapping("/delete-order/{orderId}")
    public String deleteOrderOfAUser(@PathVariable("orderId") int orderId) throws OrderDoesNotExistsException {
        return ordersService.deleteOrderOfAUser(orderId);
    }
    @GetMapping("/get-the-highest-value-order")
    public OrderResponseDto getTheHighestValueOrderEver() {
        return ordersService.getTheHighestValueOrderEver();
    }
}
