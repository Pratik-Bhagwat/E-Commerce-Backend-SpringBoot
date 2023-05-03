package com.pratikbhagwat.ECommerce.service.Impl;

import com.pratikbhagwat.ECommerce.Dto.Request.CardRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.CardResponseDto;
import com.pratikbhagwat.ECommerce.Dto.Response.CardTypeResponseDto;
import com.pratikbhagwat.ECommerce.Transformers.CardTransformer;
import com.pratikbhagwat.ECommerce.entity.Card;
import com.pratikbhagwat.ECommerce.entity.User;
import com.pratikbhagwat.ECommerce.enums.CardType;
import com.pratikbhagwat.ECommerce.exception.NoCardFoundOfTypeVisaException;
import com.pratikbhagwat.ECommerce.exception.NoUserFoundWithThatDateException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;
import com.pratikbhagwat.ECommerce.repository.CardRepository;
import com.pratikbhagwat.ECommerce.repository.UserRepository;
import com.pratikbhagwat.ECommerce.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CardServiceImpl implements CardService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CardRepository cardRepository;

    @Override
    public String addCard(CardRequestDto cardRequestDto) throws UserNotFoundException {
        User user = userRepository.findByMobNo(cardRequestDto.getMobNo());
        if(user == null) throw new UserNotFoundException("user does not exists");

        Card card = CardTransformer.cardRequestDtoToCard(cardRequestDto);
        card.setUser(user);
        user.getCards().add(card);

        userRepository.save(user);
        return "card added successfully";
    }

    @Override
    public CardTypeResponseDto getTheMostUsedCard() {
        List<Object[]> res = cardRepository.getTheMostUsedCard();
        CardTypeResponseDto cardTypeResponseDto = new CardTypeResponseDto();
        if(!res.isEmpty()) {
            Object[] row = res.get(0);
            CardType maxCardType = (CardType) row[0];
            cardTypeResponseDto.setCardType(maxCardType);
        }
        return cardTypeResponseDto;
    }

    @Override
    public List<CardResponseDto> getAllTheVisaCardsUsers() throws NoCardFoundOfTypeVisaException {
        try{
            List<Card> cards = cardRepository.findByCardType(CardType.VISA);
            List<CardResponseDto> cardResponseDtoList = new ArrayList<>();
            for (Card card: cards) {
                CardResponseDto cardResponseDto = CardTransformer.cardToCardResponse(card);
                cardResponseDtoList.add(cardResponseDto);
            }
            return cardResponseDtoList;
        }
        catch (Exception e) {
            throw new NoCardFoundOfTypeVisaException("there are no cards of type visa");
        }
    }

    @Override
    public List<CardResponseDto> getAllTheCardsWhoesExpiryIsGreaterThan(String cardType, Date expiryDate) {
        List<Card> cards = cardRepository.getAllTheCardsWhoesExpiryIsGreaterThan(cardType,expiryDate);
        List<CardResponseDto> cardResponseDtoList = new ArrayList<>();
        for (Card card:cards) {
            CardResponseDto cardResponseDto = CardTransformer.cardToCardResponse(card);
            cardResponseDtoList.add(cardResponseDto);
        }
        return cardResponseDtoList;
    }
}
