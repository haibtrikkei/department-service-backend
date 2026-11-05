package springbootrestapi.departmentemployeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootrestapi.departmentemployeservice.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    boolean existsByDepartName(String departName);
}
