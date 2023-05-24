package com.Rohit.Dosify.VMS.Project.controller;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.UserRequestDTO;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.UserResponseDTO;
import com.Rohit.Dosify.VMS.Project.model.User;
import com.Rohit.Dosify.VMS.Project.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO savedUser = userService.addUser(userRequestDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    // find by emailid

    @GetMapping("/find-by-emailId")
    public ResponseEntity getByEmailId(@RequestParam String emailId){
        UserResponseDTO userResponseDTO = userService.getByEmailId(emailId);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.OK);
    }



    // update the name of the user mobNo

    @PutMapping("/update-the-Mobile-number")
    public ResponseEntity updateUserMob(@RequestParam int id,@RequestParam String newMob){

        userService.updateUserMob(id,newMob);
        return new ResponseEntity<>("mobile number is updated now",HttpStatus.OK);
    }

    // all the users who have not taken even a single dose

    // encountering some exception================================================
    @GetMapping("/find-unvaccinated-users")
    public ResponseEntity getAllUnvaccinatedUser(){
        List<UserResponseDTO> unvaccinatedList = userService.getAllUnvaccinatedUser();
        return  new ResponseEntity<>(unvaccinatedList,HttpStatus.OK);

    }

    // all users who are fully vaccinated.

    @GetMapping("/find-fully-vaccinated-users")
    public ResponseEntity getAllFullyVaccinatedUser(){
        List<UserResponseDTO> allFullyVaccinatedUser = userService.getAllFullyVaccinatedUser();
        return  new ResponseEntity<>(allFullyVaccinatedUser,HttpStatus.OK);

    }

    // all male users who have not taken even a single vaccine

    @GetMapping("/find-non-vaccinated-male-user")
    public ResponseEntity getNonVaccinatedMaleUser(){
        List<UserResponseDTO> allFullyVaccinatedUser = userService.getNonVaccinatedMaleUser();
        return  new ResponseEntity<>(allFullyVaccinatedUser,HttpStatus.OK);

    }

    // all female users who are fully vaccinated
    @GetMapping("/find-non-vaccinated-female-user")
    public ResponseEntity getFullVaccinatedFemaleUser(){
        List<UserResponseDTO> allFullyVaccinatedUser = userService.getFullVaccinatedFemaleUser();
        return  new ResponseEntity<>(allFullyVaccinatedUser,HttpStatus.OK);

    }

    //=====================undone
    // all users who have taken does1 but not dose2

    @GetMapping("/find-dose1-users")
    public ResponseEntity getAllDose1User(){
        List<UserResponseDTO> dose1userList = userService.getAllDose1User();
        return  new ResponseEntity<>(dose1userList,HttpStatus.OK);

    }
}
