package springbootrestapi.departmentemployeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departId;
    @Column(name = "department_name",length = 100,nullable = false,unique = true)
    private String departName;
    private String description;
    private Status status;
}
