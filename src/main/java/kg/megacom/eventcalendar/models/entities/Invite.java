package kg.megacom.eventcalendar.models.entities;

import kg.megacom.eventcalendar.enums.InviteStatus;
import kg.megacom.eventcalendar.models.entities.Meeting;
import kg.megacom.eventcalendar.models.entities.baseEntity.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "invites")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invite extends BaseEntity {

    @ManyToOne
    Meeting meeting;

    @ManyToOne
    User sendTo;

    @ManyToOne
    User userFrom;

    @Enumerated(EnumType.STRING)
    InviteStatus inviteStatus;

    @ManyToOne
    User delegateFrom;







}
