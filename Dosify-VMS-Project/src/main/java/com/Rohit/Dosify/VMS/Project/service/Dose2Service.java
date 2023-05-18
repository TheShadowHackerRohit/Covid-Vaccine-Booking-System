package com.Rohit.Dosify.VMS.Project.service;

import com.Rohit.Dosify.VMS.Project.Enum.VaccineType;
import com.Rohit.Dosify.VMS.Project.model.Dose2;
import com.Rohit.Dosify.VMS.Project.model.User;

public interface Dose2Service {

    public Dose2 createDose2(User user , VaccineType vaccineType);
}
