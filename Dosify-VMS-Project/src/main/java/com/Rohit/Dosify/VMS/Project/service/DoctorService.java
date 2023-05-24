package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.DoctorRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.CenterDoesNotExist;
import com.Rohit.Dosify.VMS.Project.exception.DoctorNotFound;

import java.util.List;

public interface DoctorService {

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterDoesNotExist;

   public List<DoctorResponseDto> getDoctorsHaving10Appointment();

   public List<DoctorResponseDto> getDoctorAbove40();

   public double getDoctorGenderRatio();


   public String updateEmailId(int id, String newEmailId) throws DoctorNotFound;
}
