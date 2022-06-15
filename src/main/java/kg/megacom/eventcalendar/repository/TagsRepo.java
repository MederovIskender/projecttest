package kg.megacom.eventcalendar.repository;

import kg.megacom.eventcalendar.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TagsRepo extends JpaRepository<Tag, Long> {

    List<Tag> findAllByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update Tag t set t.name = ?2, t.color = ?3, t.is_hidden = ?4 where t.id = ?1 and t.user.id = ?5")
    void updateTagInfo(Long id, String name, String color, boolean is_hidden, Long userId);

    Optional<Tag> findByIdAndUserId(Long id, Long userId);
}
