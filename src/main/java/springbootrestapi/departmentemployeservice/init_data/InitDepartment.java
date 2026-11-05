package springbootrestapi.departmentemployeservice.init_data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springbootrestapi.departmentemployeservice.entity.Department;
import springbootrestapi.departmentemployeservice.entity.Status;
import springbootrestapi.departmentemployeservice.repository.DepartmentRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDepartment implements CommandLineRunner {
    private final DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Department> departments = List.of(
                new Department(null,"Dev 1","Phòng Dev 1", Status.ACTIVE),
                new Department(null,"Dev 2","Phòng Dev 2", Status.ACTIVE),
                new Department(null,"Dev 3","Phòng Dev 3", Status.ACTIVE),
                new Department(null,"Dev 4","Phòng Dev 4", Status.ACTIVE)
        );
        departmentRepository.saveAll(departments);
    }
}
