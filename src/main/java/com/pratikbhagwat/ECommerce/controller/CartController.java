package com.pratikbhagwat.ECommerce.controller;

import com.pratikbhagwat.ECommerce.Dto.Request.CheckOutCartRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Request.ItemRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.CartResponseDto;
import com.pratikbhagwat.ECommerce.Dto.Response.OrderResponseDto;
import com.pratikbhagwat.ECommerce.entity.Item;
import com.pratikbhagwat.ECommerce.exception.ProductNotFoundException;
import com.pratikbhagwat.ECommerce.exception.ProductOutOfStockException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;
import com.pratikbhagwat.ECommerce.service.CartService;
import com.pratikbhagwat.ECommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    ItemService itemService;
    @Autowired
    CartService cartService;
    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){
        try{
            Item savedItem = itemService.addItem(itemRequestDto);
            CartResponseDto cartResponseDto = cartService.addToCart(itemRequestDto.getUserId(),savedItem);
            return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/checkout")
    public OrderResponseDto checkOutCart(@RequestBody CheckOutCartRequestDto checkOutCartRequestDto) throws Exception {
        return cartService.checkOutCart(checkOutCartRequestDto);
    }
    @DeleteMapping("/remove/{userId}/{itemId}")
    public String removeFromCart(@PathVariable("userId") int userId,@PathVariable("itemId") int itemId) throws UserNotFoundException {
        return cartService.removeFromCart(userId,itemId);
    }
}
