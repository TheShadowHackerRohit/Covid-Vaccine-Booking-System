package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.Enum.Gender;
import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.DoctorRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.CenterDoesNotExist;
import com.Rohit.Dosify.VMS.Project.exception.DoctorNotFound;
import com.Rohit.Dosify.VMS.Project.model.Doctor;
import com.Rohit.Dosify.VMS.Project.model.VaccinationCenter;
import com.Rohit.Dosify.VMS.Project.repository.CenterRepository;
import com.Rohit.Dosify.VMS.Project.repository.DoctorRepository;
import com.Rohit.Dosify.VMS.Project.service.DoctorService;
import com.Rohit.Dosify.VMS.Project.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    CenterRepository centerRepository;

    @Autowired
    DoctorRepository doctorRepository;



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

    @Override
    public List<DoctorResponseDto> getDoctorsHaving10Appointment() {

        //DoctorResponseDto doctorResponseDto = new DoctorResponseDto();

        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();

        List<Doctor> doctorsList = doctorRepository.findAll();
        for (Doctor doctor : doctorsList){
            if(doctor.getAppointments().size()>=10){
                doctorResponseDtos.add(DoctorTransformer.DoctorToDoctorResponse(doctor));
            }
        }

        return doctorResponseDtos;
    }

    @Override
    public List<DoctorResponseDto> getDoctorAbove40() {
        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();

        List<Doctor> doctorsList = doctorRepository.findAll();
        for (Doctor doctor : doctorsList){
            if(doctor.getAge() > 40){
                doctorResponseDtos.add(DoctorTransformer.DoctorToDoctorResponse(doctor));
            }
        }

        return doctorResponseDtos;
    }

    @Override
    public double getDoctorGenderRatio() {
        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();

        double male = 0;
        double female = 0;

        List<Doctor> doctorsList = doctorRepository.findAll();
        for (Doctor doctor : doctorsList){
           if(doctor.getGender().equals(Gender.MALE)){
               male++;
           }
            if(doctor.getGender().equals(Gender.FEMALE)){
                female++;
            }
        }

        return male/female;
    }

    @Override
    public String updateEmailId(int id, String newEmailId) throws DoctorNotFound {
       // return null;
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);

        if(doctorOptional.isEmpty()){
            throw new DoctorNotFound("Invalid Doctor Id");
        }

        Doctor doctor = doctorOptional.get();

        doctor.setEmailId(newEmailId);

        return "Email Id updated";

    }
}
