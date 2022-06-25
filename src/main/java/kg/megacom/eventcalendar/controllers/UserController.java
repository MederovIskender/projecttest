package kg.megacom.eventcalendar.controllers;

import kg.megacom.eventcalendar.models.dtos.userDtos.UserCreationDto;
import kg.megacom.eventcalendar.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("createUser")
    public ResponseEntity<?>saveUser(@RequestBody UserCreationDto userCreationDto){
       return userService.saveUser(userCreationDto);
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<?>getAllUsers(){
        return userService.getAllUsers();
    }




}
