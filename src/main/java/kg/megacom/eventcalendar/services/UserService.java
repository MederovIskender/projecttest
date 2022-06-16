package kg.megacom.eventcalendar.services;

import kg.megacom.eventcalendar.models.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);
}
