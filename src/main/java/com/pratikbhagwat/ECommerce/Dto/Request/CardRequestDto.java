package com.pratikbhagwat.ECommerce.Dto.Request;

import com.pratikbhagwat.ECommerce.enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardRequestDto {
    String mobNo;
    String cardNo;
    int cardCvv;
    Date cardExpiryDate;
    CardType cardType;
}
