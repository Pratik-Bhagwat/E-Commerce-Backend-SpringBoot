package com.pratikbhagwat.ECommerce.Dto.Response;

import com.pratikbhagwat.ECommerce.enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponseDto {
    String userName;
    CardType cardType;
    String cardNo;
}
