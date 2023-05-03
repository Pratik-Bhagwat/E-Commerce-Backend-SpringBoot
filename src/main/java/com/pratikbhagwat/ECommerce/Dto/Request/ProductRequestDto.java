package com.pratikbhagwat.ECommerce.Dto.Request;

import com.pratikbhagwat.ECommerce.enums.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductRequestDto {
    String productName;
    int price;
    int quantity;
    ProductCategory productCategory;
    int sellerId;
}
