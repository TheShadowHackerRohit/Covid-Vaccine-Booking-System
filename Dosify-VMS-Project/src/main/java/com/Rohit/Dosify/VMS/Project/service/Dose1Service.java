package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.Enum.VaccineType;
import com.Rohit.Dosify.VMS.Project.model.Dose1;
import com.Rohit.Dosify.VMS.Project.model.User;

public interface Dose1Service {

    public Dose1 createDose1(User user , VaccineType vaccineType);
}
