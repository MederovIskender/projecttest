package kg.megacom.eventcalendar.services.impl;

import kg.megacom.eventcalendar.models.dtos.TagDto;
import kg.megacom.eventcalendar.models.entities.Tag;
import kg.megacom.eventcalendar.models.entities.User;
import kg.megacom.eventcalendar.repository.TagsRepo;
import kg.megacom.eventcalendar.services.TagsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TagsServiceImpl implements TagsService {

    private final TagsRepo tagsRepo;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseEntity<?> getAllTagsByUserId(Long userId){
        return new ResponseEntity<>(this.tagsRepo.findAllByUserId(userId).stream()
                .map(tag -> modelMapper.map(tag, TagDto.class))
                .collect(Collectors.toList())
                , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createNewTag(TagDto tagDto, User user){
        long savedTagId = this.tagsRepo.save(Tag.builder()
                .name(tagDto.getName())
                .color(tagDto.getColor())
                .is_hidden(tagDto.is_hidden())
                .user(user)
                .build()).getId();
        return new ResponseEntity<>("Метка с id = " + savedTagId + " успешно создана.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> changeTagInfo(TagDto tagDto, User user){
        this.tagsRepo.updateTagInfo(tagDto.getId(), tagDto.getName(), tagDto.getColor(), tagDto.is_hidden(), user.getId());
        return new ResponseEntity<>("Даные метки с id = " + tagDto.getId() + " успешно изменены", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteTagFromDB(Long tagId, User user){
        if(this.tagsRepo.findByIdAndUserId(tagId, user.getId()).isEmpty())
            return new ResponseEntity<>(String.format("Метка с id = %s у пользователем с id = %s не найдена", tagId, user.getId()), HttpStatus.NOT_FOUND);
        this.tagsRepo.deleteById(tagId);
        return new ResponseEntity<>("Метка с id = " + tagId + " успешно удалена", HttpStatus.OK);
    }

}
