package classmanage;

import java.util.*;
public class Md.FaisalSheikh_2311554642_Assignment-1 {
    static String[] Studentid = { "S1" , "S2" , "S3" };
    static String[] Studentpassword = {"password" , "password" , "password" };
    static String[] Studentname = {"A" , "B" , "C" };
    static String[] Teacherid = { "T1" , "T2" };
    static String[] Teacherpassword = {"password" , "password"};
    static String[] Teachername = {"A" , "B"};
    static String[] Coursename = {"Course A" ,"Course A" ,"Course A" ,"Course B" ,"Course C" ,"Course C"};
    static int[] Section = {1,2,3,1,1,2};
    static String[] Timing = { "A" , "A" , "B" , "D" , "B" , "C"};
    static String[] Teacher = { "T1" , "T2" , "T1" , "T1" , "T2" , "T1" };
    static String[][] Studentcourses = new String[3][6];
    
            public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            while(true)
            {
                System.out.println("Who are you?");
                System.out.println("1:Student 2:Teacher");
                int user = input.nextInt();
                if(user == 1)
                {
                    student(input);
                }
                else if(user == 2)
                {
                    teacher(input);
                }
            }
        }
            
                public static void student(Scanner input){
                    System.out.print("Provide Student ID: ");
                    String Id = input.next();
                    int index = -1;
                    for (int i = 0; i < Studentid.length; i++) {
                        if (Studentid[i].equals(Id)) {
                           index = i;
                           break;
                        }
                    }
                        if(index == -1){
                        System.out.println("Invalid ID");
                        return;
                    }
                        System.out.print("Password : ");
                        String password = input.next();
                        if(!password.equals(Studentpassword[index])){
                        System.out.println("Invalid password");
                        return;
                        }
                    System.out.println("Welcome Student "+Studentname[index] + "!");
                    while(true){
                        System.out.println("1:Add Course 2:View Course 3:Back");
                        int choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                addCourse(input,index);
                                break;
                            case 2:
                                viewCourse(input,index);
                                break;
                            case 3:
                                return;
                            default:
                                break;
                        }
                    }
                }
                
                public static void addCourse(Scanner input,int studentIndex){
                    System.out.println("Add course for Course A section 1 enter 1,section 2 enter 2,section 3 enter 3 , for Course B section 1 enter 4 and for Course C section 1 enter 5,section 2 enter 6");
                    while(true){
                        System.out.println("Press 0 to go back.");
                        for(int i = 0;i<Coursename.length;i++){
                            System.out.println((i+1)+": "+Coursename[i]+" ");
                        }                    
                        System.out.print("Course selected : ");
                        int courseIndex = input.nextInt()-1;
                        if(courseIndex == -1){
                            return;
                        }
                        if(courseIndex < 0 || courseIndex >= Coursename.length){
                            System.out.println("Invalid input");
                            continue;
                        }
                        System.out.print("Section selected : ");
                        int sectionSelected = input.nextInt();
                        if(Section[courseIndex] != sectionSelected){
                        System.out.println("Invalid section");
                        continue;
                    }
                    Studentcourses[studentIndex][courseIndex] = Coursename[courseIndex] +"."+Section[courseIndex];
                    System.out.println("You have been enrolled in \"" + Studentcourses[studentIndex][courseIndex] + "\" Sucessfully!");
                  }          
                }
                
                public static void viewCourse(Scanner input,int studentIndex){
                    while(true){
                        boolean hasCourses = false;
                        for(int i =0;i<Studentcourses[studentIndex].length;i++){
                                if(Studentcourses[studentIndex][i] != null){
                                        hasCourses = true;
                                        break;
                                        
                            }
                        }
                        if(!hasCourses){
                                System.out.println("No courses to show");
                                System.out.println("1:Back");
                                int back = input.nextInt();
                                if(back == 1){
                                    return;
                                }
                            }
                            for(int i=0;i<Studentcourses[studentIndex].length;i++)
                            {
                                if(Studentcourses[studentIndex][i] != null){
                                    System.out.println((i+1) + ": " + Studentcourses[studentIndex][i]);       
                                }
                            }
                            System.out.println("1: Remove Course 2: Back");
                            int choice = input.nextInt();
                            if(choice == 1)
                            {
                                System.out.println("Remove Course for A.1 enter 1,A.2 enter 2,A.3 enter 3 , for Course B.1 enter 4 and for Course C.1 enter 5,C.2 enter 6");
                                System.out.print("Index of course to be removed: ");
                                int courseIndex = input.nextInt()-1;
                                if(courseIndex < 0 || courseIndex >= Studentcourses[studentIndex].length || Studentcourses[studentIndex][courseIndex] == null){
                                        System.out.println("Invalid input");
                                        continue;
                                    }
                                System.out.println("You have dropped \"" +Studentcourses[studentIndex][courseIndex]+"\"Successfully!");                        
                                Studentcourses[studentIndex][courseIndex] = null;
                            }
                                    else if(choice == 2){
                                    return;
                                }
                            }
                }
                            public static void teacher(Scanner input){
                                System.out.print("Provide Teacher ID: ");
                                String Id = input.next();
                                int index = -1;
                                for (int i = 0; i < Teacherid.length; i++) {
                                    if (Teacherid[i].equals(Id)) {
                                        index = i;
                                        break;
                                    }
                                }
                                if(index == -1){
                                    System.out.println("Invalid ID");
                                    return;
                                }
                                System.out.print("Password :");
                                String password = input.next();
                                if(!password.equals(Teacherpassword[index])){
                                    System.out.println("Invalid password");
                                    return;
                                }
                                System.out.println("Welcome Teacher "+Teachername[index]+"!");
                                while(true){
                                    System.out.println("1: View Courses 2: Logout");
                                    int choice = input.nextInt();
                                    if(choice == 1){
                                        viewTeacherCourses(input,index);
                                    }
                                    else if(choice == 2){
                                        return; 
                                    }
                            }
                        }
                            public static void viewTeacherCourses(Scanner input,int teacherIndex) {
                                while(true){
                                    int count = 0;
                                    for(int i=0;i<Coursename.length;i++)
                                    {
                                        if(Teacher[i].equals(Teacherid[teacherIndex]))
                                        {
                                            count++;
                                            System.out.println(count + ": "+ Coursename[i] + "." + Section[i]);
                                        }
                                    }
                                    System.out.println((count+1)+": Back");
                                    int choice = input.nextInt();
                                    if(choice == count+1){
                                        return;
                                    }
                                    if(choice < 1 || choice > count){
                                    System.out.println("Invalid input");
                                    continue;
                                    }
                                    int courseIndex = -1;
                                    for(int i=0;i<Coursename.length;i++){
                                        if(Teacher[i].equals(Teacherid[teacherIndex])){
                                               choice--;
                                               if(choice == 0){
                                                   courseIndex = i;
                                                   break;
                                                }
                                            }
                                        }
                                        listStudents(input,courseIndex);
                                        }
                                    }
                            public static void listStudents(Scanner input,int courseIndex){
                                    while(true){
                                    System.out.println("List of Students:");
                                    for(int i = 0;i<Studentid.length;i++){
                                        if(Studentcourses[i][courseIndex] != null){
                                                System.out.println(Studentname[i]);
                                        }
                                    }
                                    System.out.println("Press 0 to go Back");
                                    int back = input.nextInt();
                                    if(back == 0){
                                        return;
                                    }
                                }
                            }
                        }
