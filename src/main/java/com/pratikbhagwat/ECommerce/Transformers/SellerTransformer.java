package com.pratikbhagwat.ECommerce.Transformers;

import com.pratikbhagwat.ECommerce.Dto.Request.SellerRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.SellerResponseDto;
import com.pratikbhagwat.ECommerce.entity.Seller;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerTransformer {
    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto) {
        return Seller.builder()
                .sellerName(sellerRequestDto.getSellerName())
                .age(sellerRequestDto.getAge())
                .mobNo(sellerRequestDto.getMobNo())
                .emailId(sellerRequestDto.getEmailId())
                .build();
    }

    public static SellerResponseDto sellerToSellerResponseDto(Seller seller) {
        return SellerResponseDto.builder()
                .sellerName(seller.getSellerName())
                .age(seller.getAge())
                .mobNo(seller.getMobNo())
                .emailId(seller.getEmailId())
                .build();
    }
}
