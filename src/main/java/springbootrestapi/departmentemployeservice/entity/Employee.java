package springbootrestapi.departmentemployeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long empId;
    private String code;
    @Column(name = "full_name",length = 70,nullable = false)
    private String fullName;
    @Column(name = "email",length = 100,nullable = false,unique = true)
    private String email;
    private String phone;
    private Double salary;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "department_id")
    private Department department;
}
