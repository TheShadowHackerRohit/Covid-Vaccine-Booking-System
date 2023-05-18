package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.DoctorRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.CenterDoesNotExist;
import com.Rohit.Dosify.VMS.Project.model.Doctor;
import com.Rohit.Dosify.VMS.Project.model.VaccinationCenter;
import com.Rohit.Dosify.VMS.Project.repository.CenterRepository;
import com.Rohit.Dosify.VMS.Project.service.DoctorService;
import com.Rohit.Dosify.VMS.Project.transformer.CenterTransformer;
import com.Rohit.Dosify.VMS.Project.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    CenterRepository centerRepository;



    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterDoesNotExist {

       Optional<VaccinationCenter> optionalCenter = centerRepository.findById(doctorRequestDto.getCenterId());
       if(optionalCenter.isEmpty()){
           throw new CenterDoesNotExist("Center Does Not present ");
       }
       VaccinationCenter center = optionalCenter.get();

       //dto to entity

        Doctor doctor = DoctorTransformer.DoctorRequestToDoctor(doctorRequestDto);
        doctor.setVaccinationCenter(center);

        // add doctor to the current list of doctors at that center
        center.getDoctors().add(doctor);

        // save both doctor and doctor
        VaccinationCenter savedCenter = centerRepository.save(center);


        // prepare response dto

        DoctorResponseDto doctorResponseDto = DoctorTransformer.DoctorToDoctorResponse(doctor);


        return doctorResponseDto;





    }
}
