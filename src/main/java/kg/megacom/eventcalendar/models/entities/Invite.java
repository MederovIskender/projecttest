package kg.megacom.eventcalendar.models.entities;

import kg.megacom.eventcalendar.enums.InviteStatus;
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
    AppUser sendTo;

    @ManyToOne
    AppUser appUserFrom;

    @Enumerated(EnumType.STRING)
    InviteStatus inviteStatus;

    @ManyToOne
    AppUser delegateFrom;







}
