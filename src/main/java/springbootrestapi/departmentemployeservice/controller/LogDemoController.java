package springbootrestapi.departmentemployeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootrestapi.departmentemployeservice.dto.response.ApiResponse;
import springbootrestapi.departmentemployeservice.dto.response.DepartmentResponse;
import springbootrestapi.departmentemployeservice.service.DepartmentService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/demo-log")
public class LogDemoController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentResponse>>> getDepartments() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách phòng ban thành công",
                departmentService.getListDepartments(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }
}
