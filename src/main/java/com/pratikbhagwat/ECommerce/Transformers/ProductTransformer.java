package com.pratikbhagwat.ECommerce.Transformers;

import com.pratikbhagwat.ECommerce.Dto.Request.ProductRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.ProductResponseDto;
import com.pratikbhagwat.ECommerce.entity.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductTransformer {
    public static ProductResponseDto productToProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productCategory(product.getProductCategory())
                .sellerName(product.getSeller().getSellerName())
                .build();
    }

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto) {
        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productCategory(productRequestDto.getProductCategory())
                .build();
    }
}
