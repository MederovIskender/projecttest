package kg.megacom.eventcalendar.repository;

import kg.megacom.eventcalendar.models.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findById(long id);
}
