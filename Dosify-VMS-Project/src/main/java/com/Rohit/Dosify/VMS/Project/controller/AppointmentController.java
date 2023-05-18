package com.Rohit.Dosify.VMS.Project.controller;


import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.AppointmentRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @PostMapping("/add-appointment")
    public ResponseEntity addAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto){

    }


}
