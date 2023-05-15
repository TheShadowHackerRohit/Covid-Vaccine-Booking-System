package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.UserRequestDTO;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.UserResponseDTO;
import com.Rohit.Dosify.VMS.Project.model.User;
import com.Rohit.Dosify.VMS.Project.repository.UserRepository;
import com.Rohit.Dosify.VMS.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {

        //convert request DTO to entity
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setAge(userRequestDTO.getAge());
        user.setEmailId(userRequestDTO.getEmailId());
        user.setMobNo(userRequestDTO.getMobNo());
        user.setGender(userRequestDTO.getGender());

        //save the entity to the db
        User savedUser = userRepository.save(user);

        //convert entity to response DTO
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(savedUser.getName());
        userResponseDTO.setMessage("Congrats! You have registered on Dosify");

        return userResponseDTO;



    }
}
