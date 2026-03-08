package pkgclass.management.system;
import java.util.*;

public class ClassManagementSystem {
    Scanner input = new Scanner(System.in);
    public static void teacher(Scanner input){
           if(teacher == "T1" || teacher == "T2")`
           {
                System.out.println("Please enter the password:");
                String Password = input.nextLine();
                if(Password == password)
                {
                    System.out.println("Welcome Teacher A!");
                }
           }
}
    public String teacherID(){
           System.out.println("Provide teacher ID:");
           String Teacher = input.nextLine();        
           
    }
    public static void main(String[] args) {
        System.out.println("Who are you?");
        System.out.println("Press 1 for Student and Press 2 for Teacher");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if(num == 2)
        {
            teacher();
        }
    }   
}