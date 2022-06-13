package kg.megacom.eventcalendar.models.entities;


import kg.megacom.eventcalendar.models.entities.baseEntity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "roomns")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room extends BaseEntity {

    @OneToMany(mappedBy = "room")
    List<Meeting>meetings;

    @Column(name = "room_number")
    int roomNumber;

    int capacity;

    @Column(name = "projector_available")
    boolean projectorAvailable;

    @Column(name = "board_available")
    boolean boardAvailable;

    String location;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    String description;

    @Column(name = "is_active")
    boolean isActive;







}
