package com.Rohit.Dosify.VMS.Project.controller;

import com.Rohit.Dosify.VMS.Project.Enum.CenterType;
import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.CenterRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    CenterService centerService;

    @PostMapping("/add-center")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterRequestDto centerRequestDto){

       CenterResponseDto centerResponseDto = centerService.addVaccinationCenter(centerRequestDto);
       return new ResponseEntity(centerResponseDto, HttpStatus.CREATED);
    }

    // give the list of all doctors at a particular center(centerId)
    @GetMapping("/get-all-doctors")
    public ResponseEntity getAllDoctorsInACenter(@RequestParam int id){
        List<DoctorResponseDto> doctorResponseDtoList = centerService.getAllDoctorsInACenter(id);

        return new ResponseEntity(doctorResponseDtoList,HttpStatus.OK);

    }

    // give the list of all male doctors at a particular center(centerId)

    @GetMapping("/get-all-male-doctors")
    public ResponseEntity getAllMaleDoctorsInACenter(@RequestParam int id){
        List<DoctorResponseDto> doctorResponseDtoList = centerService.getAllMaleDoctorsInACenter(id);

        return new ResponseEntity(doctorResponseDtoList,HttpStatus.OK);

    }

    // give the list of all females doctors at a particular center(centerId)
    @GetMapping("/get-all-female-doctors")
    public ResponseEntity getAllFeMaleDoctorsInACenter(@RequestParam int id){
        List<DoctorResponseDto> doctorResponseDtoList = centerService.getAllFeMaleDoctorsInACenter(id);

        return new ResponseEntity(doctorResponseDtoList,HttpStatus.OK);

    }

    // give the list of all male doctors above age 40 at a particular center(centerId)
    @GetMapping("/get-all-doctors-above-age")
    public ResponseEntity getAllMaleDoctorsAboveAgeInACenter(@RequestParam int id){
        List<DoctorResponseDto> doctorResponseDtoList = centerService.getAllMaleDoctorsAboveAgeInACenter(id);

        return new ResponseEntity(doctorResponseDtoList,HttpStatus.OK);

    }

    // give all centers of a particular centerType

    @GetMapping("/get-all-centers-of-centerType")
    public ResponseEntity getAllCenterOfACenterType(@RequestParam CenterType centerType){
        List<CenterResponseDto> doctorResponseDtoList = centerService.getAllCenterOfACenterType(centerType);

        return new ResponseEntity(doctorResponseDtoList,HttpStatus.OK);

    }
}
