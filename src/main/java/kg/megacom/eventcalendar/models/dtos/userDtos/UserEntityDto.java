package kg.megacom.eventcalendar.models.dtos.userDtos;

import lombok.*;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityDto {
        Long id;
        String firstName;
        String lastName;
        String patronymic;
        String msisdn;
        String email;
        String password;
        String position;
        Long DepartmentId;
}
