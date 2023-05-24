package com.Rohit.Dosify.VMS.Project.dto.ResponseDTO;

import com.Rohit.Dosify.VMS.Project.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data//to String, EqualsAndHashCode ,Getter, Setter, RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponseDTO {


    String name;

    String message;

    int age ;

    String mobNo;

    Gender gender;







}
