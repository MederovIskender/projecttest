package kg.megacom.eventcalendar.models.entities;

import kg.megacom.eventcalendar.models.entities.baseEntity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    @Column
    String name;

    @ManyToMany
    List<AppUser> appUsers;

    @ManyToOne
    Organization organization;

    @ManyToOne
    AppUser head;
}
