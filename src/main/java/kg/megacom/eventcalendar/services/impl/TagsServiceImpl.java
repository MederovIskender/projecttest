package kg.megacom.eventcalendar.services.impl;

import kg.megacom.eventcalendar.exceptions.UserNotFoundExceptions;
import kg.megacom.eventcalendar.models.dtos.TagDto;
import kg.megacom.eventcalendar.models.entities.Tag;
import kg.megacom.eventcalendar.models.entities.User;
import kg.megacom.eventcalendar.repository.TagsRepo;
import kg.megacom.eventcalendar.services.TagsService;
import kg.megacom.eventcalendar.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TagsServiceImpl implements TagsService {

    private final TagsRepo tagsRepo;
    private final UserService userService;

    @Override
    public ResponseEntity<?> getAllTagsByUserId(Long userId) {
        return new ResponseEntity<>(this.tagsRepo.findAllByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createNewTag(TagDto tagDto, Long userId){
        Optional<User> userById = this.userService.getUserById(userId);
        if(userById.isEmpty()){
            return new ResponseEntity<>(new UserNotFoundExceptions("Пользователь с id = " + userId + " не найден."), HttpStatus.NOT_FOUND);
        }

        long savedTagId = this.tagsRepo.save(Tag.builder()
                .name(tagDto.getName())
                .color(tagDto.getColor())
                .is_hidden(tagDto.is_hidden())
                .user(userById.get())
                .build()).getId();
        return new ResponseEntity<>("Метка с id = " + savedTagId + " успешно создана.", HttpStatus.OK);
    }

}
