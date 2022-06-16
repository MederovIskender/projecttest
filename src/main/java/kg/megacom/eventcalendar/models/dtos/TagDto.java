package kg.megacom.eventcalendar.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

    Long id;

    @NotNull(message = "Заполните название создаваемой метки")
    String name;

    @NotNull(message = "Укажите цвет создаваемой метки")
    String color;

    @NotNull(message = "Требуемый уровень скрытности отсутствует")
    boolean is_hidden;
}
