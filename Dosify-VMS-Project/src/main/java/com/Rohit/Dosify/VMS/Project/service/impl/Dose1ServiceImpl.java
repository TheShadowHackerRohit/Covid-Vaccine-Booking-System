package com.Rohit.Dosify.VMS.Project.service.impl;

import com.Rohit.Dosify.VMS.Project.Enum.VaccineType;
import com.Rohit.Dosify.VMS.Project.model.Dose1;
import com.Rohit.Dosify.VMS.Project.model.User;
import com.Rohit.Dosify.VMS.Project.service.Dose1Service;

import java.util.UUID;

public class Dose1ServiceImpl implements Dose1Service {


    // make a transformer here
    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {

        Dose1  dose1 = Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();

        return dose1;
    }
}
