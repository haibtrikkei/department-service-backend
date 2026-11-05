package springbootrestapi.departmentemployeservice.exception;

public class DepartmentNameExistException extends RuntimeException{
    public DepartmentNameExistException(String message){
        super(message);
    }
}
