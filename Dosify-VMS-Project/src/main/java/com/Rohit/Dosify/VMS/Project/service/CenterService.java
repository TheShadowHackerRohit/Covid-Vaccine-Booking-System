package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.Enum.CenterType;
import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.CenterRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CenterService {
    CenterResponseDto addVaccinationCenter(CenterRequestDto centerRequestDto);

    List<DoctorResponseDto> getAllDoctorsInACenter(int id);

    List<DoctorResponseDto> getAllMaleDoctorsInACenter(int id);

    List<DoctorResponseDto> getAllFeMaleDoctorsInACenter(int id);

    List<DoctorResponseDto> getAllMaleDoctorsAboveAgeInACenter(int id);

    List<CenterResponseDto> getAllCenterOfACenterType(CenterType centerType);
}
