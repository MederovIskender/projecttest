package kg.megacom.eventcalendar.services.impl;

import kg.megacom.eventcalendar.enums.Status;
import kg.megacom.eventcalendar.models.dtos.ResponseMessage;
import kg.megacom.eventcalendar.models.dtos.userDtos.UserCreationDto;
import kg.megacom.eventcalendar.models.dtos.userDtos.UserEntityDto;
import kg.megacom.eventcalendar.models.entities.AppUser;
import kg.megacom.eventcalendar.repository.UserRepo;
import kg.megacom.eventcalendar.services.DepartmentService;
import kg.megacom.eventcalendar.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepo userRepo;
    DepartmentService departmentService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<AppUser> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public ResponseEntity<?> saveUser(UserCreationDto userCreationDto) {
      long userId = userRepo.save(AppUser.builder()
              .first_name(userCreationDto.getFirstName())
              .last_name(userCreationDto.getLastName())
              .patronymic(userCreationDto.getPatronymic())
                      .email(userCreationDto.getEmail())
                      .msisdn(userCreationDto.getMsisdn())
                      .password(userCreationDto.getPassword())
                      .status(Status.ACTIVE)
                      .departments(List.of(departmentService.findDepartmentById(userCreationDto.getDepartmentId()).get()))
              .build()).getId();
        return new ResponseEntity<>(new ResponseMessage(userId," пользователь с id " + userId + " был создан"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> blockUser(long userId) {
        AppUser appUser = userRepo.findById(userId);
        appUser.setStatus(Status.BANNED);
        userRepo.save(appUser);
        long id = appUser.getId();
        return new ResponseEntity<>(new ResponseMessage(id, " пользователь с ID "+ id + " был забанен"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userRepo.findAll().stream()
                .map(appUser -> modelMapper.map(appUser, UserEntityDto.class))
                .collect(Collectors.toList()), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> updateUser(UserEntityDto userEntityDto) {
        userRepo
        return
    }

}
