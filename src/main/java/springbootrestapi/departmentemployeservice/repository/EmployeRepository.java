package springbootrestapi.departmentemployeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootrestapi.departmentemployeservice.entity.Employee;
@Repository
public interface EmployeRepository extends JpaRepository<Employee,Long> {
}
