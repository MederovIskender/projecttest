package kg.megacom.eventcalendar.models.entities;

import kg.megacom.eventcalendar.enums.Status;
import kg.megacom.eventcalendar.enums.UserRole;
import kg.megacom.eventcalendar.models.entities.baseEntity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column
    String first_name;

    @Column
    String last_name;

    @Column
    String patronymic;

    @Column
    String msisdn;

    @Column
    String email;

    @Column
    String password;

    @Enumerated(EnumType.STRING)
    @Column
    UserRole role;

    @Builder.Default
    Status status = Status.ACTIVE;

    @ManyToMany(mappedBy = "users")
    List<Position> positions;

    @ManyToMany(mappedBy = "users")
    List<Department> departments;
}
