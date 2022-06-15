package kg.megacom.eventcalendar.repository;

import kg.megacom.eventcalendar.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagsRepo extends JpaRepository<Tag, Long> {

    List<Tag> findAllByUserId(Long userId);
}
