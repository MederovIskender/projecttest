package kg.megacom.eventcalendar.models.dtos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {

    Long Id;
    String firstName;
    String lastName;
    String patronymic;

}
