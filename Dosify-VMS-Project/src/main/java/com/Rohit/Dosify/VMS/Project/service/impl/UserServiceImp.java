package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.UserRequestDTO;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.UserResponseDTO;
import com.Rohit.Dosify.VMS.Project.model.User;
import com.Rohit.Dosify.VMS.Project.repository.UserRepository;
import com.Rohit.Dosify.VMS.Project.service.UserService;
import com.Rohit.Dosify.VMS.Project.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {

        //convert request DTO to entity
//        User user = new User();
//        user.setName(userRequestDTO.getName());
//        user.setAge(userRequestDTO.getAge());
//        user.setEmailId(userRequestDTO.getEmailId());
//        user.setMobNo(userRequestDTO.getMobNo());
//        user.setGender(userRequestDTO.getGender());


        //user object using builder
        User user = UserTransformer.UserRequestDtoToUser(userRequestDTO);


        //save the entity to the db
        User savedUser = userRepository.save(user);

        //convert entity to response DTO
//        UserResponseDTO userResponseDTO = new UserResponseDTO();
//        userResponseDTO.setName(savedUser.getName());
//        userResponseDTO.setMessage("Congrats! You have registered on Dosify");

        //userResponse object using builder
        UserResponseDTO userResponseDTO = UserTransformer.UserToUserResponseDto(savedUser);

        return userResponseDTO;

    }

    @Override
    public UserResponseDTO getByEmailId(String emailId) {
        User savedUser = userRepository.getByEmailId(emailId);

        UserResponseDTO userResponseDTO = UserTransformer.UserToEmailUserResponseDto(savedUser);

        return userResponseDTO;
    }

    @Override
    public void updateUserMob(int id, String newMob) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        user.setMobNo(newMob);

    }

    @Override
    public List<UserResponseDTO> getAllUnvaccinatedUser() {

        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        List<User> userList = userRepository.getAllUnvaccinatedUser();

        for(User user : userList){
                    userResponseDTOList.add(UserTransformer.UserToEmailUserResponseDto(user));
            }
        return userResponseDTOList;
    }

    @Override
    public List<UserResponseDTO> getAllFullyVaccinatedUser() {

        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        List<User> userList = userRepository.getAllFullyVaccinatedUser();

        for(User user : userList){
            userResponseDTOList.add(UserTransformer.UserToEmailUserResponseDto(user));
        }
        return userResponseDTOList;
    }

    @Override
    public List<UserResponseDTO> getNonVaccinatedMaleUser() {


        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        List<User> userList = userRepository.getNonVaccinatedMaleUser();

        for(User user : userList){
            userResponseDTOList.add(UserTransformer.UserToEmailUserResponseDto(user));
        }
        return userResponseDTOList;

    }

    @Override
    public List<UserResponseDTO> getFullVaccinatedFemaleUser() {

        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        List<User> userList = userRepository.getFullVaccinatedFemaleUser();

        for(User user : userList){
            userResponseDTOList.add(UserTransformer.UserToEmailUserResponseDto(user));
        }
        return userResponseDTOList;

    }


    @Override
    public List<UserResponseDTO> getAllDose1User() {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        try{
            List<User> userList = userRepository.getOnlyDose1User();
            for(User user : userList){
                userResponseDTOList.add(UserTransformer.UserToEmailUserResponseDto(user));
            }
        }catch (Exception e){
            System.out.println("userRepository.getOnlyDose1User() pr Exception aarha hai be");
        }
        return userResponseDTOList;
    }


}
