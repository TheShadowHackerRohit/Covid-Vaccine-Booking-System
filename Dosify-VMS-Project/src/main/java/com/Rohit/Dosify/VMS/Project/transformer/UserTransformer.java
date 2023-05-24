package com.Rohit.Dosify.VMS.Project.transformer;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.UserRequestDTO;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.UserResponseDTO;
import com.Rohit.Dosify.VMS.Project.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {

    public static User UserRequestDtoToUser(UserRequestDTO userRequestDTO){
        return  User.builder()
                .name(userRequestDTO.getName())
                .age(userRequestDTO.getAge())
                .emailId(userRequestDTO.getEmailId())
                .mobNo(userRequestDTO.getMobNo())
                .gender(userRequestDTO.getGender())
                .build();
    }
    public static UserResponseDTO UserToUserResponseDto(User user){
        return  UserResponseDTO.builder()
                .name(user.getName())
                .message("Congrats! You have registered on Dosify")
                .build();
    }

    public static UserResponseDTO UserToEmailUserResponseDto(User user){

        String str = "";
        if(user.isDose2Taken()){
            str = "Both dose  has been taken";
        } else if (user.isDose1Taken()) {
            str ="Dose 1 has been taken";
        } else if (!user.isDose1Taken()) {
            str = "No dose has been taken yet";

        }

        return UserResponseDTO.builder()
                .name(user.getName())
                .age(user.getAge())
                .mobNo(user.getMobNo())
                .gender(user.getGender())
                .message(str)
                .build();
    }
}
