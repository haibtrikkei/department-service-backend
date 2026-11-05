package springbootrestapi.departmentemployeservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootrestapi.departmentemployeservice.dto.request.DepartmentRequest;
import springbootrestapi.departmentemployeservice.dto.response.DepartmentResponse;
import springbootrestapi.departmentemployeservice.entity.Department;
import springbootrestapi.departmentemployeservice.exception.DepartmentNameExistException;
import springbootrestapi.departmentemployeservice.repository.DepartmentRepository;
import springbootrestapi.departmentemployeservice.service.DepartmentService;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponse> getListDepartments() {
        log.info("getListDepartments()");
        return
                departmentRepository.findAll().stream().map(d -> DepartmentResponse.builder()
                        .departId(d.getDepartId())
                        .departName(d.getDepartName())
                        .description(d.getDescription())
                        .status(d.getStatus())
                        .build()).toList();
    }

    @Override
    public DepartmentResponse insertDepartment(DepartmentRequest departmentRequest) {
        if(departmentRepository.existsByDepartName(departmentRequest.getDepartName())){
            throw new DepartmentNameExistException("Tên phòng ban đã tồn tại");
        }
        Department department = Department.builder()
                .departName(departmentRequest.getDepartName())
                .description(departmentRequest.getDescription())
                .status(departmentRequest.getStatus())
                .build();
        Department saved = departmentRepository.save(department);
        log.info("Thêm mới phòng ban "+saved.getDepartName()+" thành công");
        return DepartmentResponse.builder()
                .departId(saved.getDepartId())
                .departName(saved.getDepartName())
                .description(saved.getDescription())
                .status(saved.getStatus())
                .build();
    }
}
