package com.Rohit.Dosify.VMS.Project.controller;


import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.DoctorRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.CenterDoesNotExist;
import com.Rohit.Dosify.VMS.Project.exception.DoctorNotFound;
import com.Rohit.Dosify.VMS.Project.model.Doctor;
import com.Rohit.Dosify.VMS.Project.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // get all the doctors who have more than 10 appointment
    @GetMapping("/doctors-10-appointment")
    public ResponseEntity getDoctorsHaving10Appointment(){
        List<DoctorResponseDto> doctorResponseDto = doctorService.getDoctorsHaving10Appointment();
        return new ResponseEntity(doctorResponseDto,HttpStatus.OK);

    }

    // get all the male doctors whose age is above 40

    @GetMapping("/doctors-above-age-40")
    public ResponseEntity getDoctorAbove40(){
        List<DoctorResponseDto> doctorResponseDto = doctorService.getDoctorAbove40();
        return new ResponseEntity(doctorResponseDto,HttpStatus.OK);

    }

        // get the ratio of male to female doctors

    @GetMapping("/doctors-gender-ratio")
    public ResponseEntity getDoctorGenderRatio(){
        double ratio = doctorService.getDoctorGenderRatio() ;
        return new ResponseEntity(ratio,HttpStatus.OK);

    }


        //update the details based on email id of the doctor

    @PutMapping("/update-the-email-id")
    public ResponseEntity updateEmailId(@RequestParam int id , @RequestParam String newEmailId){

        try{
            String response = doctorService.updateEmailId(id,newEmailId);

            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (DoctorNotFound e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
