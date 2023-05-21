package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.AppointmentRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.AppointmentResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.DoctorNotFound;
import com.Rohit.Dosify.VMS.Project.exception.NotEligibleForDoseException;
import com.Rohit.Dosify.VMS.Project.exception.UserNotFound;

public interface AppointmentService {

    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFound, DoctorNotFound, NotEligibleForDoseException;

}
