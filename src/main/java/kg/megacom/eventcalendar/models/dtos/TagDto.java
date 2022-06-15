package kg.megacom.eventcalendar.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

    Long id;

    String name;

    String color;

    boolean is_hidden;
}
