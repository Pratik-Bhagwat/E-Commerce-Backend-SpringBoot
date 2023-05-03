package com.pratikbhagwat.ECommerce.controller;

import com.pratikbhagwat.ECommerce.Dto.Request.UserRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.UserResponseDto;
import com.pratikbhagwat.ECommerce.enums.CardType;
import com.pratikbhagwat.ECommerce.exception.NoUserFoundWithThisEmailException;
import com.pratikbhagwat.ECommerce.exception.ThereIsNoUserWithThisCardTypeException;
import com.pratikbhagwat.ECommerce.exception.UserAlreadyExistException;
import com.pratikbhagwat.ECommerce.exception.UserNotFoundException;
import com.pratikbhagwat.ECommerce.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto) throws UserAlreadyExistException{
        return userService.addUser(userRequestDto);
    }
    @GetMapping("/get-all")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/get-by-email")
    public UserResponseDto getUserByEmail(@RequestParam("emailId") String emailId) throws UserNotFoundException {
        return userService.getUserByEmail(emailId);
    }
    @GetMapping("/get/{age}")
    public List<UserResponseDto> getAllUsersGreaterThanAge(@PathVariable int age) {
        return userService.getAllUsersGreaterThanAge(age);
    }
    @GetMapping("/get-by/{cardType}")
    public List<UserResponseDto> getAllUsersWithCardType(@PathVariable CardType cardType) throws ThereIsNoUserWithThisCardTypeException {
        return userService.getAllUsersWithCardType(cardType);
    }
    @PutMapping("/update-by-email")
    public String updateUserByEmail(@RequestParam("emailId") String emailId,@RequestBody UserRequestDto userRequestDto) throws NoUserFoundWithThisEmailException {
        return userService.updateUserByEmail(emailId,userRequestDto);
    }
    @DeleteMapping("/delete-by-mob")
    public String deleteByMob(@RequestParam("mobNo") String mobNo) throws UserNotFoundException {
        return userService.deleteByMob(mobNo);
    }
}
