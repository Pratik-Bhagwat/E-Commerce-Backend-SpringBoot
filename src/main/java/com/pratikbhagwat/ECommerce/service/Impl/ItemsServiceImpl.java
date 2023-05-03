package com.pratikbhagwat.ECommerce.service.Impl;

import com.pratikbhagwat.ECommerce.Dto.Request.ItemRequestDto;
import com.pratikbhagwat.ECommerce.Transformers.ItemTransformer;
import com.pratikbhagwat.ECommerce.entity.Item;
import com.pratikbhagwat.ECommerce.entity.Product;
import com.pratikbhagwat.ECommerce.entity.User;
import com.pratikbhagwat.ECommerce.enums.ProductStatus;
import com.pratikbhagwat.ECommerce.exception.ProductNotFoundException;
import com.pratikbhagwat.ECommerce.exception.ProductOutOfStockException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;
import com.pratikbhagwat.ECommerce.repository.ItemRepository;
import com.pratikbhagwat.ECommerce.repository.ProductRepository;
import com.pratikbhagwat.ECommerce.repository.UserRepository;
import com.pratikbhagwat.ECommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;
    @Override
    public Item addItem(ItemRequestDto itemRequestDto) throws UserNotFoundException, ProductNotFoundException, ProductOutOfStockException {
        User user;
        Product product;
        try{
            user = userRepository.findById(itemRequestDto.getUserId()).get();
        }
        catch (Exception e) {
            throw new UserNotFoundException("there is no user with this userId");
        }
        try{
           product = productRepository.findById(itemRequestDto.getProductId()).get();
        }
        catch (Exception e) {
            throw new ProductNotFoundException("there is no product with this productId");
        }

        if(itemRequestDto.getRequiredQuantity() > product.getQuantity() || product.getProductStatus() == ProductStatus.OUT_OF_STOCK) {
            throw new ProductOutOfStockException("Sorry Product out Stock!!!");
        }
        Item item = ItemTransformer.itemRequestDtoToItem(itemRequestDto);
        item.setProduct(product);
        product.getItems().add(item);

        return itemRepository.save(item);
    }
}
