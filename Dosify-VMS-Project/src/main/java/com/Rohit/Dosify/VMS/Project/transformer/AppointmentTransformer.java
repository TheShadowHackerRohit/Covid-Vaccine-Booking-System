package com.Rohit.Dosify.VMS.Project.transformer;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.AppointmentRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.AppointmentResponseDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.model.Appointment;
import com.Rohit.Dosify.VMS.Project.model.Doctor;
import com.Rohit.Dosify.VMS.Project.model.User;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class AppointmentTransformer {


        public static AppointmentResponseDto modelsToAppointmentResponseDto(Doctor doctor, User user, Appointment appointment, Appointment savedAppointment, AppointmentRequestDto appointmentRequestDto){

            CenterResponseDto centerResponseDto = CenterTransformer.CenterToCenterResponse(doctor.getVaccinationCenter());


            AppointmentResponseDto appointmentResponseDto = AppointmentResponseDto.builder()
                    .userName(user.getName())
                    .appointmentNo(appointment.getAppointmentNo())
                    .dateOfAppointment(savedAppointment.getDateOfAppointment())
                    .doseNo(appointment.getDoseNo())
                    .centerResponseDto(centerResponseDto)
                    .doctorName(doctor.getName())
                    .vaccineType(appointmentRequestDto.getVaccineType())
                    .build();

            return appointmentResponseDto;
        }

        public static Appointment modelsToAppointment(AppointmentRequestDto appointmentRequestDto,User user,Doctor doctor){
              return  Appointment.builder()
                        .appointmentNo(String.valueOf(UUID.randomUUID()))
                        .doseNo(appointmentRequestDto.getDoseNo())
                        .user(user)
                        .doctor(doctor)
                        .build();
    }

}
