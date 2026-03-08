package employee;

public class InvalidDepartmentException extends Exception{
    public InvalidDepartmentException(String excep){
        super(excep);
    }
    @Override
    public String toString(){
        return "Invalid Department: "+super.getMessage();
    }
}
