package kg.megacom.eventcalendar.services;

import kg.megacom.eventcalendar.models.dtos.TagDto;
import kg.megacom.eventcalendar.models.entities.User;
import org.springframework.http.ResponseEntity;

public interface TagsService {

    ResponseEntity<?> getAllTagsByUserId(Long userId);

    ResponseEntity<?> createNewTag(TagDto tagDto, User user);

    ResponseEntity<?> changeTagInfo(TagDto tagDto, User user);

    ResponseEntity<?> deleteTagFromDB(Long tagId, User user);
}
