package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.Enum.DoseNo;
import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.AppointmentRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.AppointmentResponseDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.DoctorNotFound;
import com.Rohit.Dosify.VMS.Project.exception.NotEligibleForDoseException;
import com.Rohit.Dosify.VMS.Project.exception.UserNotFound;
import com.Rohit.Dosify.VMS.Project.model.*;
import com.Rohit.Dosify.VMS.Project.repository.DoctorRepository;
import com.Rohit.Dosify.VMS.Project.repository.UserRepository;
import com.Rohit.Dosify.VMS.Project.service.AppointmentService;
import com.Rohit.Dosify.VMS.Project.service.Dose1Service;
import com.Rohit.Dosify.VMS.Project.service.Dose2Service;
import com.Rohit.Dosify.VMS.Project.transformer.AppointmentTransformer;
import com.Rohit.Dosify.VMS.Project.transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    Dose1Service dose1Service;

    @Autowired
    Dose2Service dose2Service;


    @Autowired
    private JavaMailSender emailSender;



    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFound, DoctorNotFound, NotEligibleForDoseException {

       Optional<User> userOptional =  userRepository.findById(appointmentRequestDto.getUserId());
       if (userOptional.isEmpty()){
           throw new UserNotFound("USer Not Found");
       }

       Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());
       if (optionalDoctor.isEmpty()){
           throw  new DoctorNotFound("doctor not found");
       }

       User user = userOptional.get();
       Doctor doctor = optionalDoctor.get();

       if(appointmentRequestDto.getDoseNo()== DoseNo.DOSE_1){
           Dose1 dose1 = dose1Service.createDose1(user,appointmentRequestDto.getVaccineType());
           user.setDose1Taken(true);
           user.setDose1(dose1);
       }
       else{
           if(!user.isDose1Taken()){
               throw new NotEligibleForDoseException("Sorry! you are not eligible for Dose 2");

           }
           Dose2 dose2 = dose2Service.createDose2(user,appointmentRequestDto.getVaccineType());
           user.setDose2Taken(true);
           user.setDose2(dose2);

       }

        Appointment appointment = AppointmentTransformer.modelsToAppointment(appointmentRequestDto,user,doctor);


       user.getAppointments().add(appointment);
       User savedUser =  userRepository.save(user);// save dose1 and dose2 and appointment

        Appointment savedAppointment = savedUser.getAppointments().get(savedUser.getAppointments().size()-1);

        doctor.getAppointments().add(savedAppointment);
        doctorRepository.save(doctor);

        //send email
            String text = "Congrats !"+ user.getName()+ " Your dose "+ appointmentRequestDto.getDoseNo() +" has been booked";
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("rohitsahume0104@gmail.com");
            message.setTo(user.getEmailId());
            message.setSubject("Appointment Booked !!!!");
            message.setText(text);
            emailSender.send(message);

        //prepare response dto

        AppointmentResponseDto appointmentResponseDto = AppointmentTransformer.modelsToAppointmentResponseDto(doctor,user,appointment,savedAppointment,appointmentRequestDto);


        return appointmentResponseDto;


    }
}
