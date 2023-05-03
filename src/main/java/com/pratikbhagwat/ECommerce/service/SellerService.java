package com.pratikbhagwat.ECommerce.service;

import com.pratikbhagwat.ECommerce.Dto.Request.SellerEmailRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Request.SellerIdRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Request.SellerRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.SellerResponseDto;
import com.pratikbhagwat.ECommerce.exception.SellerAlreadyExistsException;
import com.pratikbhagwat.ECommerce.exception.SellerNotFoundException;

import java.util.List;

public interface SellerService {
    String addSeller(SellerRequestDto sellerRequestDto) throws SellerAlreadyExistsException;

    SellerResponseDto getSellerByEmail(SellerEmailRequestDto sellerEmailRequestDto) throws SellerNotFoundException;

    SellerResponseDto getSellerById(SellerIdRequestDto sellerIdRequestDto) throws SellerNotFoundException;

    List<SellerResponseDto> getAllSellers();

    SellerResponseDto updateSellerByEmail(String emailId, SellerRequestDto sellerRequestDto);

    String deleteSellerByEmail(SellerEmailRequestDto sellerEmailRequestDto) throws SellerNotFoundException;

    String deleteSellerById(SellerIdRequestDto sellerIdRequestDto) throws SellerNotFoundException;
}
