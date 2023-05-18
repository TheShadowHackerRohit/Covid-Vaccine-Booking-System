package com.Rohit.Dosify.VMS.Project.dto.RequestDTO;

import com.Rohit.Dosify.VMS.Project.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data//to String, EqualsAndHashCode ,Getter, Setter, RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorRequestDto {


    int centerId;

    String name;

    int age;

    String emailId;

    String mobNo;

    Gender gender;


}
