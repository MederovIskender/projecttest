package kg.megacom.eventcalendar.services;

import kg.megacom.eventcalendar.models.dtos.TagDto;
import org.springframework.http.ResponseEntity;

public interface TagsService {

    ResponseEntity<?> getAllTagsByUserId(Long userId);

    ResponseEntity<?> createNewTag(TagDto tagDto, Long userId);
}
