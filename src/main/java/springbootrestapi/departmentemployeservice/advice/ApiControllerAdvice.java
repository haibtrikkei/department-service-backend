package springbootrestapi.departmentemployeservice.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springbootrestapi.departmentemployeservice.dto.response.ApiResponse;
import springbootrestapi.departmentemployeservice.dto.response.ErrorResponse;
import springbootrestapi.departmentemployeservice.exception.DepartmentNameExistException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
@Slf4j
public class ApiControllerAdvice {
    @ExceptionHandler(DepartmentNameExistException.class)
    public ResponseEntity<ApiResponse<Object>> handleDepartmentNameExistException(DepartmentNameExistException ex) {
        log.warn(ex.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(
                false,
                "Lỗi thêm mới phòng ban",
                null,
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .error(ex.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new TreeMap<>();
        ex.getFieldErrors().stream().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));

        return new ResponseEntity<>(new ApiResponse<>(
                false,
                "Lỗi tham số truyền",
                null,
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .error(errors)
                        .build(),
                HttpStatus.BAD_REQUEST
        ), HttpStatus.BAD_REQUEST);
    }
}
