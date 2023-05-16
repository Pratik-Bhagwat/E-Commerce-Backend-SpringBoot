package com.pratikbhagwat.ECommerce.Transformers;

import com.pratikbhagwat.ECommerce.Dto.Response.CartResponseDto;
import com.pratikbhagwat.ECommerce.entity.Cart;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CartTransformer {
    public static CartResponseDto cartToCartResponseDto(Cart cart) {
        return CartResponseDto.builder()
                .cartTotal(cart.getTotalCost())
                .numberOfItems(cart.getNumberOfItems())
                .userName(cart.getUser().getUserName())
                .build();
    }
}
