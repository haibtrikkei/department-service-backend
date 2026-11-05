package springbootrestapi.departmentemployeservice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestapi.departmentemployeservice.dto.request.DepartmentRequest;
import springbootrestapi.departmentemployeservice.dto.response.ApiResponse;
import springbootrestapi.departmentemployeservice.dto.response.DepartmentResponse;
import springbootrestapi.departmentemployeservice.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentResponse>>> getAllDepartments() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách phòng ban thành công",
                departmentService.getListDepartments(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentResponse>> createDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Thêm mới phòng ban " + departmentRequest.getDepartName() + " thành công",
                departmentService.insertDepartment(departmentRequest),
                null,
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }
}
