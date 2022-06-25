package kg.megacom.eventcalendar.services;

import kg.megacom.eventcalendar.models.dtos.TagDto;
import kg.megacom.eventcalendar.models.entities.AppUser;
import org.springframework.http.ResponseEntity;

public interface TagsService {

    ResponseEntity<?> getAllTagsByUserId(Long userId);

    ResponseEntity<?> createNewTag(TagDto tagDto, AppUser appUser);

    ResponseEntity<?> changeTagInfo(TagDto tagDto, AppUser appUser);

    ResponseEntity<?> deleteTagFromDB(Long tagId, AppUser appUser);
}
