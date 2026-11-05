package springbootrestapi.departmentemployeservice.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbootrestapi.departmentemployeservice.entity.Department;
import springbootrestapi.departmentemployeservice.entity.Status;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeResponse {
    private Long empId;
    private String code;
    private String fullName;
    private String email;
    private String phone;
    private Double salary;
    private Status status;
    private Department department;
}
