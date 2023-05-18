package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.DoctorRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.CenterDoesNotExist;

public interface DoctorService {

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterDoesNotExist;

}
