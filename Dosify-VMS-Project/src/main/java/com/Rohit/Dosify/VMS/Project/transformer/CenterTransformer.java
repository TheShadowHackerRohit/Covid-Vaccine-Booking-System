package com.Rohit.Dosify.VMS.Project.transformer;

import com.Rohit.Dosify.VMS.Project.dto.RequestDTO.CenterRequestDto;
import com.Rohit.Dosify.VMS.Project.dto.ResponseDTO.CenterResponseDto;
import com.Rohit.Dosify.VMS.Project.model.VaccinationCenter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CenterTransformer {

    public static VaccinationCenter CenterRequestDtoToCenter(CenterRequestDto centerRequestDto){
        return VaccinationCenter.builder()
                .name(centerRequestDto.getName())
                .location(centerRequestDto.getLocation())
                .centerType(centerRequestDto.getCenterType())
                .build();
    }

    public static CenterResponseDto CenterToCenterResponse(VaccinationCenter vaccinationCenter){
        return CenterResponseDto.builder()
                .name(vaccinationCenter.getName())
                .location(vaccinationCenter.getLocation())
                .centerType(vaccinationCenter.getCenterType())
                .build();
    }

}
