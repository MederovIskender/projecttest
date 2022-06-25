package kg.megacom.eventcalendar.controllers;

import kg.megacom.eventcalendar.enums.Status;
import kg.megacom.eventcalendar.enums.UserRole;
import kg.megacom.eventcalendar.models.dtos.TagDto;
import kg.megacom.eventcalendar.models.entities.AppUser;
import kg.megacom.eventcalendar.services.TagsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// uncomment and refactor all commented code in this method when security for user (UserDetails and UserDetailsService) will be done
@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController {

    private final TagsService tagsService;

    // test user that needs until security for user will be done (as soon as security is done you can easily remove it)
    private final AppUser testAppUser = AppUser.builder()
            .email("danya1102119@gmail.com")
            .first_name("Данил")
            .last_name("Третьяков")
            .msisdn("+996-555-555-555")
            .password("")
            .patronymic("$2a$10$vj/cwCnfo.Ek26D6/OkMCesW0pD3IXuVoc3pGEnFGG/sDLujoBnFy")
            .role(UserRole.ROLE_SUPER_ADMIN)
            .status(Status.ACTIVE)
            .build();

    @GetMapping("/all")
    public ResponseEntity<?> getAllTagsByUser(/*Authentication auth*/){
        /* MySecurityUser secUser = (MySecurityUser) auth.getPrincipal();*/
        return this.tagsService.getAllTagsByUserId(1L /*secUser.getUser().getId()*/);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewTag(@Valid @RequestBody TagDto tagDto/*, Authentication auth*/){
        /* MySecurityUser secUser = (MySecurityUser) auth.getPrincipal();*/
        testAppUser.setId(1);
        return this.tagsService.createNewTag(tagDto, testAppUser/*secUser.getUser()*/);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTagById(@RequestParam @NotNull @Pattern(regexp = "[0-9]+") Long id/*, Authentication auth*/){
        /* MySecurityUser secUser = (MySecurityUser) auth.getPrincipal();*/
        testAppUser.setId(1);
        return this.tagsService.deleteTagFromDB(id, testAppUser/*secUser.getUser()*/);
    }

    @PutMapping("/{tagId}/update")
    public ResponseEntity<?> updateTagInfo(@Valid @RequestBody TagDto tagDto/*, Authentication auth*/){
        /* MySecurityUser secUser = (MySecurityUser) auth.getPrincipal();*/
        testAppUser.setId(1);
        return this.tagsService.changeTagInfo(tagDto, testAppUser/*secUser.getUser()*/);
    }
}
