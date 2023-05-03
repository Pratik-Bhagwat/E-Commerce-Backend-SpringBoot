package com.pratikbhagwat.ECommerce.repository;

import com.pratikbhagwat.ECommerce.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
