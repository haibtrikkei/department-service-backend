package springbootrestapi.departmentemployeservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbootrestapi.departmentemployeservice.entity.Status;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DepartmentRequest {
    @NotBlank(message = "Không được để trống tên phòng ban")
    private String departName;
    @NotBlank(message = "Không được để trống mô tả")
    private String description;
    @NotNull(message = "Không được để trống trạng thái")
    private Status status;
}
