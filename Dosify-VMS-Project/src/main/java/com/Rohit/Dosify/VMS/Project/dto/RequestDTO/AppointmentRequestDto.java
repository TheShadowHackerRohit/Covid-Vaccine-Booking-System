package com.Rohit.Dosify.VMS.Project.dto.RequestDTO;


import com.Rohit.Dosify.VMS.Project.Enum.DoseNo;
import com.Rohit.Dosify.VMS.Project.Enum.VaccineType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data//to String, EqualsAndHashCode ,Getter, Setter, RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDto {

    DoseNo doseNo;

    int userId;

    int doctorId;

    VaccineType vaccineType;

}
