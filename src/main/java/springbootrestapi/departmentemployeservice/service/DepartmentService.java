package springbootrestapi.departmentemployeservice.service;

import org.w3c.dom.stylesheets.LinkStyle;
import springbootrestapi.departmentemployeservice.dto.request.DepartmentRequest;
import springbootrestapi.departmentemployeservice.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> getListDepartments();
    DepartmentResponse insertDepartment(DepartmentRequest departmentRequest);
}
