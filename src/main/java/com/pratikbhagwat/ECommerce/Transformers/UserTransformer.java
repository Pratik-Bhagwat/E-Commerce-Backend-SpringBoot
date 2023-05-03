package com.pratikbhagwat.ECommerce.Transformers;

import com.pratikbhagwat.ECommerce.Dto.Request.UserRequestDto;
import com.pratikbhagwat.ECommerce.Dto.Response.UserResponseDto;
import com.pratikbhagwat.ECommerce.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {
    public static User userRequestDtoToUser(UserRequestDto userRequestDto) {

        return User.builder()
                .userName(userRequestDto.getUserName())
                .emailId(userRequestDto.getEmailId())
                .mobNo(userRequestDto.getMobNo())
                .address(userRequestDto.getAddress())
                .age(userRequestDto.getAge())
                .build();
    }
    public static UserResponseDto userToUserResponseDto(User user) {
        return UserResponseDto.builder()
                .userName(user.getUserName())
                .mobNo(user.getMobNo())
                .age(user.getAge())
                .emailId(user.getEmailId())
                .build();
    }
}
