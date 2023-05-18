package com.Rohit.Dosify.VMS.Project.controller;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.CenterRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}