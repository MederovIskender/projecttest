package kg.megacom.eventcalendar.services;

import kg.megacom.eventcalendar.models.dtos.userDtos.UserCreationDto;
import kg.megacom.eventcalendar.models.dtos.userDtos.UserEntityDto;
import kg.megacom.eventcalendar.models.entities.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<AppUser> getUserById(Long id);

    ResponseEntity<?> saveUser(UserCreationDto userCreationDto);
    ResponseEntity<?> blockUser(long userId);
    ResponseEntity<?> getAllUsers();
    ResponseEntity<?> updateUser(UserEntityDto userEntityDto);

}
