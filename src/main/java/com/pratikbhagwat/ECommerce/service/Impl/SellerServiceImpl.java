package com.pratikbhagwat.ECommerce.service.Impl;

import com.pratikbhagwat.ECommerce.Dto.Request.SellerEmailRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Request.SellerIdRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Request.SellerRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.SellerResponseDto;
import com.pratikbhagwat.ECommerce.Transformers.SellerTransformer;
import com.pratikbhagwat.ECommerce.entity.Seller;
import com.pratikbhagwat.ECommerce.exception.SellerAlreadyExistsException;
import com.pratikbhagwat.ECommerce.exception.SellerNotFoundException;
import com.pratikbhagwat.ECommerce.repository.SellerRepository;
import com.pratikbhagwat.ECommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepository sellerRepository;
    @Override
    public String addSeller(SellerRequestDto sellerRequestDto) throws SellerAlreadyExistsException {
        if(sellerRepository.findByEmailId(sellerRequestDto.getEmailId())!=null){
            throw new SellerAlreadyExistsException("seller already exists");
        }
        Seller seller = SellerTransformer.sellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);
        return "seller added successfully";
    }

    @Override
    public SellerResponseDto getSellerByEmail(SellerEmailRequestDto sellerEmailRequestDto) throws SellerNotFoundException {
        try{
            Seller seller = sellerRepository.findByEmailId(sellerEmailRequestDto.getEmailId());
            return SellerResponseDto.builder()
                    .sellerName(seller.getSellerName())
                    .age(seller.getAge())
                    .mobNo(seller.getMobNo())
                    .emailId(seller.getEmailId())
                    .build();
        }
        catch (Exception e) {
            throw new SellerNotFoundException("there no seller with this email");
        }
    }

    @Override
    public SellerResponseDto getSellerById(SellerIdRequestDto sellerIdRequestDto) throws SellerNotFoundException {
        try{
            Seller seller = sellerRepository.findById(sellerIdRequestDto.getSellerId()).get();
            return SellerResponseDto.builder()
                    .sellerName(seller.getSellerName())
                    .age(seller.getAge())
                    .mobNo(seller.getMobNo())
                    .emailId(seller.getEmailId())
                    .build();
        }
        catch (Exception e) {
            throw new SellerNotFoundException("there no seller with this id");
        }
    }

    @Override
    public List<SellerResponseDto> getAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        List<SellerResponseDto> sellerResponseDtoList = new ArrayList<>();

        for(Seller seller: sellers) {
            SellerResponseDto sellerResponseDto = SellerTransformer.sellerToSellerResponseDto(seller);
            sellerResponseDtoList.add(sellerResponseDto);
        }
        return sellerResponseDtoList;
    }

    @Override
    public SellerResponseDto updateSellerByEmail(String emailId, SellerRequestDto sellerRequestDto) {
        Seller seller = sellerRepository.findByEmailId(emailId);
        seller.setSellerName(sellerRequestDto.getSellerName());
        seller.setEmailId(sellerRequestDto.getEmailId());
        seller.setAge(sellerRequestDto.getAge());
        seller.setMobNo(sellerRequestDto.getMobNo());

        Seller saved = sellerRepository.save(seller);

        return SellerTransformer.sellerToSellerResponseDto(saved);
    }

    @Override
    public String deleteSellerByEmail(SellerEmailRequestDto sellerEmailRequestDto) throws SellerNotFoundException {
        try {
            Seller seller = sellerRepository.findByEmailId(sellerEmailRequestDto.getEmailId());
            sellerRepository.delete(seller);
            return "seller deleted successfully";
        }
        catch (Exception e) {
            throw new SellerNotFoundException("seller does not exists");
        }
    }

    @Override
    public String deleteSellerById(SellerIdRequestDto sellerIdRequestDto) throws SellerNotFoundException {
        try {
            Seller seller = sellerRepository.findById(sellerIdRequestDto.getSellerId()).get();
            sellerRepository.delete(seller);
            return "seller deleted successfully";
        }
        catch (Exception e) {
            throw new SellerNotFoundException("seller does not exists");
        }
    }
}
