package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.UserRequestDTO;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.UserResponseDTO;
import com.Rohit.Dosify.VMS.Project.model.User;

import java.util.List;

public interface UserService {

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO);

    public UserResponseDTO getByEmailId(String emailId);

    public void updateUserMob(int id, String newMob);

   public List<UserResponseDTO> getAllUnvaccinatedUser();

  public  List<UserResponseDTO> getAllFullyVaccinatedUser();

   public List<UserResponseDTO> getNonVaccinatedMaleUser();

  public List<UserResponseDTO> getFullVaccinatedFemaleUser();

    public List<UserResponseDTO> getAllDose1User();
}
