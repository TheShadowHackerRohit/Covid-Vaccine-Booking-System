package com.Rohit.Dosify.VMS.Project.controller;


import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.AppointmentRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.AppointmentResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.DoctorNotFound;
import com.Rohit.Dosify.VMS.Project.exception.NotEligibleForDoseException;
import com.Rohit.Dosify.VMS.Project.exception.UserNotFound;
import com.Rohit.Dosify.VMS.Project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book-appointment")
    public AppointmentResponseDto addAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) throws DoctorNotFound, UserNotFound, NotEligibleForDoseException {

        return appointmentService.bookAppointment(appointmentRequestDto);

    }


}
