package springbootrestapi.departmentemployeservice.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class EmployeeRequest {
    @NotBlank(message = "Không được để trống họ tên")
    private String fullName;
    @NotBlank(message = "Không được để trống email")
    @Pattern(regexp = "^(?!.*\\.\\.)[A-Za-z0-9](?:[A-Za-z0-9._%+-]{0,62}[A-Za-z0-9])?@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)+$", message = "Email không đúng định dạng")
    private String email;
    private String phone;
    @NotNull(message = "Không được để trống lương")
    private Double salary;
    @NotNull(message = "Không được để trống trạng thái")
    private Status status;
    @NotNull(message = "Không được để trống mã phòng ban")
    private Long departId;
}
