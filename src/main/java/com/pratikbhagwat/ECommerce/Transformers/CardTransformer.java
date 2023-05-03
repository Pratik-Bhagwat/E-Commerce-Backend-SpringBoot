package com.pratikbhagwat.ECommerce.Transformers;

import com.pratikbhagwat.ECommerce.Dto.Request.CardRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.CardResponseDto;
import com.pratikbhagwat.ECommerce.Dto.Response.CardTypeResponseDto;
import com.pratikbhagwat.ECommerce.entity.Card;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CardTransformer {
    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto) {
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardCvv(cardRequestDto.getCardCvv())
                .cardExpiryDate(cardRequestDto.getCardExpiryDate())
                .cardType(cardRequestDto.getCardType())
                .build();
    }
    public static CardResponseDto cardToCardResponse (Card card) {
        return CardResponseDto.builder()
                .cardNo(card.getCardNo())
                .cardType(card.getCardType())
                .userName(card.getUser().getUserName())
                .build();
    }
    public static CardTypeResponseDto cardToCardTypeResponseDto(Card card) {
        return CardTypeResponseDto.builder()
                .cardType(card.getCardType())
                .build();
    }
}
