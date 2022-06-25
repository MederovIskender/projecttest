package kg.megacom.eventcalendar.services;

import kg.megacom.eventcalendar.models.entities.Department;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface DepartmentService {

    Optional<Department>findDepartmentById(Long Id);


}
