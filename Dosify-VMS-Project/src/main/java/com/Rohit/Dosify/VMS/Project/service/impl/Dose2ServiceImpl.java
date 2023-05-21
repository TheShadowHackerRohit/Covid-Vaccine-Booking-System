package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.Enum.VaccineType;
import com.Rohit.Dosify.VMS.Project.model.Dose1;
import com.Rohit.Dosify.VMS.Project.model.Dose2;
import com.Rohit.Dosify.VMS.Project.model.User;
import com.Rohit.Dosify.VMS.Project.service.Dose2Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose2ServiceImpl implements Dose2Service {


    // make a transformer here
    @Override
    public Dose2 createDose2(User user, VaccineType vaccineType) {

        Dose2 dose2 = Dose2.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();

        return dose2;
    }
}
