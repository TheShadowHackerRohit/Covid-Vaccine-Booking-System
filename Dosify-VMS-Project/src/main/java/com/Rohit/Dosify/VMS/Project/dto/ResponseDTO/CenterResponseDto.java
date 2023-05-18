package com.Rohit.Dosify.VMS.Project.dto.ResponseDTO;


import com.Rohit.Dosify.VMS.Project.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data//to String, EqualsAndHashCode ,Getter, Setter, RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterResponseDto {

    String name;

    String location;

    CenterType centerType;
}
