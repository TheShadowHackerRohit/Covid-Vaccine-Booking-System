package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.Enum.DoseNo;
import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.AppointmentRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.AppointmentResponseDto;
import com.Rohit.Dosify.VMS.Project.exception.DoctorNotFound;
import com.Rohit.Dosify.VMS.Project.exception.UserNotFound;
import com.Rohit.Dosify.VMS.Project.model.Doctor;
import com.Rohit.Dosify.VMS.Project.model.Dose1;
import com.Rohit.Dosify.VMS.Project.model.Dose2;
import com.Rohit.Dosify.VMS.Project.model.User;
import com.Rohit.Dosify.VMS.Project.repository.DoctorRepository;
import com.Rohit.Dosify.VMS.Project.repository.UserRepository;
import com.Rohit.Dosify.VMS.Project.service.AppointmentService;
import com.Rohit.Dosify.VMS.Project.service.Dose1Service;
import com.Rohit.Dosify.VMS.Project.service.Dose2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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



    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFound, DoctorNotFound {


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
           Dose2 dose2 = dose2Service.createDose2(user,appointmentRequestDto.getVaccineType());
           user.setDose2Taken(true);
           user.setDose2(dose2);
       }

    }
}
