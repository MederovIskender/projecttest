package kg.megacom.eventcalendar.models.entities;

import kg.megacom.eventcalendar.models.entities.Room;
import kg.megacom.eventcalendar.models.entities.baseEntity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "room_inaccessibility")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomInaccessibility extends BaseEntity {
    LocalDateTime startDate;
    LocalDateTime endDate;

    @ManyToOne
    Room room;

}
