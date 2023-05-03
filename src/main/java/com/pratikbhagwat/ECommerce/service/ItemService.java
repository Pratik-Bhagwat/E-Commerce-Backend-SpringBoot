package com.pratikbhagwat.ECommerce.service;

import com.pratikbhagwat.ECommerce.Dto.Request.ItemRequestDto;
import com.pratikbhagwat.ECommerce.entity.Item;
import com.pratikbhagwat.ECommerce.exception.ProductNotFoundException;
import com.pratikbhagwat.ECommerce.exception.ProductOutOfStockException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;

public interface ItemService {
   Item addItem(ItemRequestDto itemRequestDto) throws UserNotFoundException, ProductNotFoundException, ProductOutOfStockException;
}
