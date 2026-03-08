package employee;
import java.util.Scanner;

public class Employee {
    private String name;
    private double salary;
    private String department;
    public Employee(){
    }
    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSalary(double salary) throws IllegalSalaryException {
        if(salary >= 0 && salary <= 50000){
            this.salary = salary;
        }
        else{
            throw new IllegalSalaryException("Invalid Salary: "+salary);
        }
    }
    public double getSalary(){
        return salary;
    }
    public void setDepartment(String department) throws InvalidDepartmentException {
        String[] Departments = {"Sales","Marketing","Logistics","Promotions"};
        boolean isValid = false;
        for(String validDepartments:Departments){
            if(validDepartments.equals(department)){
            isValid = true;
            this.department = department;
            break;
            }
        }
        if(!isValid){
            throw new InvalidDepartmentException("Invalid Department: "+department);
        }
    }
    public String getDepartment(){
        return department;
    }
    public void displayInfo(){
        System.out.println("Name: "+getName());
        System.out.println("Salary: "+getSalary());
        System.out.println("Department: "+getDepartment());
    }
    public double calculateBonus(double bonus) throws BeyondLimitBonusException {
        if(bonus >= 0 && bonus <= 50){
             return this.salary*(bonus/100);
        }
        else{
            throw new BeyondLimitBonusException("Invalid Bonus: "+bonus);
        }
    }
    
    public static void main(String[] args) {
        try{
            Employee employee = new Employee();      
            employee.setSalary(90000);
            employee.displayInfo();
        }
        catch(IllegalSalaryException e){
            System.out.println("IllegalSalaryException: " +e.getMessage());
        }
        try{
            Employee employee = new Employee();
            System.out.println(employee.calculateBonus(90)); 
        }
        catch(BeyondLimitBonusException e){
            System.out.println("BeyondLimitBonusException: "+e.getMessage());
        }
        try{
            Employee employee = new Employee();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Department: ");
            String department = input.nextLine();
            employee.setDepartment(department);
            employee.displayInfo();
        }
        catch(InvalidDepartmentException e){
            System.out.println("InvalidDepartmentException: "+e.getMessage());
        }
    }
}