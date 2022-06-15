package kg.megacom.eventcalendar.models.entities;

import kg.megacom.eventcalendar.models.entities.baseEntity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class Tag extends BaseEntity {

    @Column
    String name;

    @Column
    String color;

    @Column
    boolean is_hidden;

    @ManyToOne(cascade = CascadeType.MERGE)
    User user;
}
