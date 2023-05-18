package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.CenterRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.model.VaccinationCenter;
import com.Rohit.Dosify.VMS.Project.repository.CenterRepository;
import com.Rohit.Dosify.VMS.Project.service.CenterService;
import com.Rohit.Dosify.VMS.Project.transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    CenterRepository centerRepository;

    @Override
    public CenterResponseDto addVaccinationCenter(CenterRequestDto centerRequestDto) {
        // dto => entity
        VaccinationCenter vaccinationCenter = CenterTransformer.CenterRequestDtoToCenter(centerRequestDto);

        //save your db
        VaccinationCenter savedCenter = centerRepository.save(vaccinationCenter);

        // entity => response dto
        CenterResponseDto centerResponseDto = CenterTransformer.CenterToCenterResponse(savedCenter);

        return centerResponseDto;

    }
}
