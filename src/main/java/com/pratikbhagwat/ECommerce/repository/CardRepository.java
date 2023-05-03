package com.pratikbhagwat.ECommerce.repository;

import com.pratikbhagwat.ECommerce.entity.Card;
import com.pratikbhagwat.ECommerce.enums.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    @Query("SELECT c.cardType, COUNT(c) as numCards FROM Card c GROUP BY c.cardType ORDER BY numCards DESC")
    List<Object[]> getTheMostUsedCard();

    List<Card> findByCardType(CardType cardType);

    @Query(value = "SELECT * FROM Card c WHERE c.card_type = :cardType AND c.card_expiry_date > :expiryDate",nativeQuery = true)
    List<Card> getAllTheCardsWhoesExpiryIsGreaterThan(String cardType, Date expiryDate);

    Card findByCardNo(String cardNo);
}
