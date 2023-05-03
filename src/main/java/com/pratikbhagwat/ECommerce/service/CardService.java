package com.pratikbhagwat.ECommerce.service;

import com.pratikbhagwat.ECommerce.Dto.Request.CardRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.CardResponseDto;
import com.pratikbhagwat.ECommerce.Dto.Response.CardTypeResponseDto;
import com.pratikbhagwat.ECommerce.enums.CardType;
import com.pratikbhagwat.ECommerce.exception.NoCardFoundOfTypeVisaException;
import com.pratikbhagwat.ECommerce.exception.NoUserFoundWithThatDateException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;

import java.util.Date;
import java.util.List;

public interface CardService {
    String addCard(CardRequestDto cardRequestDto) throws UserNotFoundException;

    CardTypeResponseDto getTheMostUsedCard();

    List<CardResponseDto> getAllTheVisaCardsUsers() throws NoCardFoundOfTypeVisaException;

    List<CardResponseDto> getAllTheCardsWhoesExpiryIsGreaterThan(String cardType, Date expiryDate);
}
