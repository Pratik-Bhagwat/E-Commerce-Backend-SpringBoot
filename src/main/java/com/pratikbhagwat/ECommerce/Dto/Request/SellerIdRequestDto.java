package com.pratikbhagwat.ECommerce.Dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerIdRequestDto {
    int sellerId;
}
