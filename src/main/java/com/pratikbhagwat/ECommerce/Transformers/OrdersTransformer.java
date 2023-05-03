package com.pratikbhagwat.ECommerce.Transformers;

import com.pratikbhagwat.ECommerce.Dto.Response.OrderResponseDto;
import com.pratikbhagwat.ECommerce.entity.Orders;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrdersTransformer {
    public static OrderResponseDto orderToOrderResponseDto(Orders orders) {
        return OrderResponseDto.builder()
                .cardUsed(orders.getCardUsed())
                .orderNo(orders.getOrderNo())
                .totalValue(orders.getTotalCost())
                .orderDate(orders.getOrderDate())
                .userName(orders.getUser().getUserName())
                .build();
    }
}
