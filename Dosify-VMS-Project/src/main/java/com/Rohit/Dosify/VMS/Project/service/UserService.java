package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.UserRequestDTO;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.UserResponseDTO;
import com.Rohit.Dosify.VMS.Project.model.User;

public interface UserService {

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO);

}
