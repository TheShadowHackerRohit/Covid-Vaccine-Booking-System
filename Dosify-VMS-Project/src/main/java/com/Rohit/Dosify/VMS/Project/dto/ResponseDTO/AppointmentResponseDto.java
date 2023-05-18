package com.Rohit.Dosify.VMS.Project.dto.ResponseDTO;

import com.Rohit.Dosify.VMS.Project.Enum.DoseNo;
import com.Rohit.Dosify.VMS.Project.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data//to String, EqualsAndHashCode ,Getter, Setter, RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {

    String userName;

    String appointmentNo;

    Date dateOfAppointment;

    DoseNo doseNo;

    String doctorName;

    CenterResponseDto centerResponseDto;

    VaccineType vaccineType;
}
