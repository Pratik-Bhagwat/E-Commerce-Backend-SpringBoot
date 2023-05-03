package com.pratikbhagwat.ECommerce.service;

import com.pratikbhagwat.ECommerce.Dto.Request.UserRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.UserResponseDto;
import com.pratikbhagwat.ECommerce.enums.CardType;
import com.pratikbhagwat.ECommerce.exception.NoUserFoundWithThisEmailException;
import com.pratikbhagwat.ECommerce.exception.ThereIsNoUserWithThisCardTypeException;
import com.pratikbhagwat.ECommerce.exception.UserAlreadyExistException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;
import com.pratikbhagwat.ECommerce.repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    @Autowired
    UserRepository userRepository = null;

    String addUser(UserRequestDto userRequestDto) throws UserAlreadyExistException;

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserByEmail(String emailId) throws UserNotFoundException;

    List<UserResponseDto> getAllUsersGreaterThanAge(int age);

    List<UserResponseDto> getAllUsersWithCardType(CardType cardType) throws ThereIsNoUserWithThisCardTypeException;

    String updateUserByEmail(String emailId,UserRequestDto userRequestDto) throws NoUserFoundWithThisEmailException;

    String deleteByMob(String mobNo) throws UserNotFoundException;
}
