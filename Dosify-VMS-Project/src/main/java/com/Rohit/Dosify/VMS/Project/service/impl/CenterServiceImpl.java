package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.Enum.CenterType;
import com.Rohit.Dosify.VMS.Project.Enum.Gender;
import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.CenterRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.model.Doctor;
import com.Rohit.Dosify.VMS.Project.model.VaccinationCenter;
import com.Rohit.Dosify.VMS.Project.repository.CenterRepository;
import com.Rohit.Dosify.VMS.Project.service.CenterService;
import com.Rohit.Dosify.VMS.Project.transformer.CenterTransformer;
import com.Rohit.Dosify.VMS.Project.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<DoctorResponseDto> getAllDoctorsInACenter(int id) {
        Optional<VaccinationCenter> vaccinationCenterOptional = centerRepository.findById(id);
        VaccinationCenter center = vaccinationCenterOptional.get();

        List<Doctor> doctorList = center.getDoctors();

        List<DoctorResponseDto> doctorResponseDtoList = new ArrayList<>();

        for (Doctor doctor : doctorList){
            doctorResponseDtoList.add(DoctorTransformer.DoctorToDoctorResponse(doctor));
        }

        return doctorResponseDtoList;
    }

    @Override
    public List<DoctorResponseDto> getAllMaleDoctorsInACenter(int id) {
        Optional<VaccinationCenter> vaccinationCenterOptional = centerRepository.findById(id);
        VaccinationCenter center = vaccinationCenterOptional.get();

        List<Doctor> doctorList = center.getDoctors();

        List<DoctorResponseDto> doctorResponseDtoList = new ArrayList<>();

        for (Doctor doctor : doctorList){
            if(doctor.getGender() == Gender.MALE)
            doctorResponseDtoList.add(DoctorTransformer.DoctorToDoctorResponse(doctor));
        }

        return doctorResponseDtoList;
    }

    @Override
    public List<DoctorResponseDto> getAllFeMaleDoctorsInACenter(int id) {

        Optional<VaccinationCenter> vaccinationCenterOptional = centerRepository.findById(id);
        VaccinationCenter center = vaccinationCenterOptional.get();

        List<Doctor> doctorList = center.getDoctors();

        List<DoctorResponseDto> doctorResponseDtoList = new ArrayList<>();

        for (Doctor doctor : doctorList){
            if(doctor.getGender() == Gender.FEMALE)
                doctorResponseDtoList.add(DoctorTransformer.DoctorToDoctorResponse(doctor));
        }

        return doctorResponseDtoList;
    }

    @Override
    public List<DoctorResponseDto> getAllMaleDoctorsAboveAgeInACenter(int id) {
        Optional<VaccinationCenter> vaccinationCenterOptional = centerRepository.findById(id);
        VaccinationCenter center = vaccinationCenterOptional.get();

        List<Doctor> doctorList = center.getDoctors();

        List<DoctorResponseDto> doctorResponseDtoList = new ArrayList<>();

        for (Doctor doctor : doctorList){
            if(doctor.getGender() == Gender.MALE && doctor.getAge() > 40)
                doctorResponseDtoList.add(DoctorTransformer.DoctorToDoctorResponse(doctor));
        }

        return doctorResponseDtoList;
    }

    @Override
    public List<CenterResponseDto> getAllCenterOfACenterType(CenterType centerType) {


        //Query se nhi hua hai ...exception aarha hai
//        List<VaccinationCenter> vaccinationCenterList = centerRepository.getAllCenterOfACenterType(centerType);

        List<VaccinationCenter> vaccinationCenterList = centerRepository.findAll();

        List<CenterResponseDto> centerResponseDtoList = new ArrayList<>();

        for (VaccinationCenter center : vaccinationCenterList){
            if(center.getCenterType()==centerType)//========================
            centerResponseDtoList.add(CenterTransformer.CenterToCenterResponse(center));
        }

        return centerResponseDtoList;
    }


}
