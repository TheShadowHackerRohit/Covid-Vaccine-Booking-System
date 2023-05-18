package com.Rohit.Dosify.VMS.Project.controller;


import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.DoctorRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.CenterDoesNotExist;
import com.Rohit.Dosify.VMS.Project.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add-doctor")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto){

        try {
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity<>(doctorResponseDto,HttpStatus.CREATED);

        }
        catch (CenterDoesNotExist e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
