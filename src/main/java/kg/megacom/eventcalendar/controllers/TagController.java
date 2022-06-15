package kg.megacom.eventcalendar.controllers;

import kg.megacom.eventcalendar.models.dtos.TagDto;
import kg.megacom.eventcalendar.models.entities.User;
import kg.megacom.eventcalendar.services.TagsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// uncomment and refactor all commented code in this method when security for user (UserDetails and UserDetailsService) will be done
@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController {

    private final TagsService tagsService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllTagsByUser(/*Authentication auth*/){
        /* MySecurityUser secUser = (MySecurityUser) auth.getPrincipal();*/
        return this.tagsService.getAllTagsByUserId(1L /*secUser.getUser().getId()*/);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createNewTag(@RequestBody TagDto tagDto/*, Authentication auth*/){
        /* MySecurityUser secUser = (MySecurityUser) auth.getPrincipal();*/
        return this.tagsService.createNewTag(tagDto, new User()/*secUser.getUser()*/);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTagById(@RequestParam Long id/*, Authentication auth*/){
        /* MySecurityUser secUser = (MySecurityUser) auth.getPrincipal();*/
        return this.tagsService.deleteTagFromDB(id, new User()/*secUser.getUser()*/);
    }

    @PutMapping("/{tagId}/update")
    public ResponseEntity<?> updateTagInfo(@RequestBody TagDto tagDto/*, Authentication auth*/){
        /* MySecurityUser secUser = (MySecurityUser) auth.getPrincipal();*/
        return this.tagsService.changeTagInfo(tagDto, new User()/*secUser.getUser()*/);
    }
}
