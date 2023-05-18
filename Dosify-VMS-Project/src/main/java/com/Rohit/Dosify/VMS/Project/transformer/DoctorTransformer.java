package com.Rohit.Dosify.VMS.Project.transformer;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.DoctorRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.DoctorResponseDto;
import com.Rohit.Dosify.VMS.Project.model.Doctor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {

    public static Doctor DoctorRequestToDoctor(DoctorRequestDto doctorRequestDto){
        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .mobNo(doctorRequestDto.getMobNo())
                .gender(doctorRequestDto.getGender())
                .emailId(doctorRequestDto.getEmailId())
                .build();
    }

    public static DoctorResponseDto DoctorToDoctorResponse(Doctor doctor) {

        CenterResponseDto centerResponseDto = CenterTransformer.CenterToCenterResponse(doctor.getVaccinationCenter());


        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .centerResponseDto(centerResponseDto)
                .build();
    }
}
