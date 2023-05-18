package com.Rohit.Dosify.VMS.Project.dto.ResponseDTO;

import com.Rohit.Dosify.VMS.Project.Enum.CenterType;
import com.Rohit.Dosify.VMS.Project.Enum.Gender;
import lombok.Builder;

@Builder
public class DoctorResponseDto  {


    String name;

    String emailId;

    String mobNo;

    CenterResponseDto centerResponseDto;





}
