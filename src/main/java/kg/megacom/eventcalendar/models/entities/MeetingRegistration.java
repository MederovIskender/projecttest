package kg.megacom.eventcalendar.models.entities;

import kg.megacom.eventcalendar.enums.UserStatusInTheMeeting;
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
@Table(name = "meeting_registration")
public class MeetingRegistration extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "delegate_id")
    User delegate;

    @Column(name = "user_cancelled")
    boolean user_cancelled;

    @Enumerated(EnumType.STRING)
    @Column
    UserStatusInTheMeeting status;

    @ManyToOne
    Tag tag;

}
