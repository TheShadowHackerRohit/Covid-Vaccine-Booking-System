package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.CenterRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import org.springframework.http.ResponseEntity;

public interface CenterService {
    CenterResponseDto addVaccinationCenter(CenterRequestDto centerRequestDto);

}
