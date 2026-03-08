import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

class User {
    public String email;
    public String password;
    public String name;

    public User(){
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

class Student extends User implements Action {
    public String studentId;
    public double gpa;
    public ArrayList<Course> courses = new ArrayList<Course>();
    public Student(){
    }
    public Student(String email, String password, String name, String studentId, double gpa) {
        super(email, password, name);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public void handleActions() {
        while (true) {
            System.out.println("1: Add Course 2: View Courses 3: Logout");
            int action = Session.getSession().inputScanner.nextInt();
            Session.getSession().inputScanner.nextLine();

            if (action == 1) {
                addCourse();
            } else if (action == 2) {
                viewCourses();
            } else if (action == 3) {
                break;
            }
        }
    }

    private void addCourse() {
        Session session = Session.getSession();
        Course[] courseList = session.getCourseList();

        System.out.println("Courses available for enrollment:");
        for (int i = 0; i < courseList.length; i++) {
            System.out.println((i + 1) + ": " + courseList[i].name);
        }

        System.out.println("Enter the course number to enroll (0 to cancel):");
        int courseNumber = session.inputScanner.nextInt();
        session.inputScanner.nextLine();

        if (courseNumber == 0) {
            return;
        }

        Course selectedCourse = courseList[courseNumber - 1];

        if (isTimingOverlap(selectedCourse)) {
            System.out.println("Course timing overlaps with another enrolled course.");
            return;
        }

        if (courses.contains(selectedCourse)) {
            System.out.println("You are already enrolled in this course.");
            return;
        }

        courses.add(selectedCourse);
        System.out.println("Enrolled in course: " + selectedCourse.name);
    }


    private boolean isRegisteredInCourse(Course course) {
        for (Course enrolledCourse : courses) {
            if (enrolledCourse.name.equals(course.name)) {
                return true;
            }
        }
        return false;
    }


    private boolean isTimingOverlap(Course selectedCourse) {
        for (Course course : courses) {
            int startTime = course.startTime;
            int endTime = course.endTime;
            int selectedStartTime = selectedCourse.startTime;
            int selectedEndTime = selectedCourse.endTime;

            if (selectedStartTime < endTime && selectedEndTime > startTime) {
                return true;
            }
        }
        return false;
    }

    private void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses to show.");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ": " + courses.get(i).name);
        }

        System.out.println("1: Remove Course 2: Back");
        int subAction = Session.getSession().inputScanner.nextInt();
        Session.getSession().inputScanner.nextLine();

        if (subAction == 1) {
            removeCourse();
        }
    }

    private void removeCourse() {
        if (courses.isEmpty()) {
            System.out.println("No courses to remove.");
            return;
        }

        System.out.println("Enter the course number to remove (0 to cancel):");
        int courseNumber = Session.getSession().inputScanner.nextInt();
        Session.getSession().inputScanner.nextLine();

        if (courseNumber == 0) {
            return;
        }

        if (courseNumber >= 1 && courseNumber <= courses.size()) {
            Course removedCourse = courses.remove(courseNumber - 1);
            System.out.println("Removed course: " + removedCourse.name);
        } else {
            System.out.println("Invalid course number.");
        }
    }
}

class Teacher extends User implements Action {
    public String teacherId;
    public ArrayList<Section> sections = new ArrayList<Section>();
    public Teacher(){
    }
    public Teacher(String email, String password, String name, String teacherId) {
        super(email, password, name);
        this.teacherId = teacherId;
    }

    @Override
    public void handleActions() {
        while (true) {
            System.out.println("1: View Courses 2: Remove Student 3: Logout");
            int action = Session.getSession().inputScanner.nextInt();
            Session.getSession().inputScanner.nextLine();

            if (action == 1) {
                viewCourses();
            } else if (action == 2) {
                removeStudent();
            } else if (action == 3) {
                break;
            }
        }
    }

    private void viewCourses() {
        if (sections.isEmpty()) {
            System.out.println("You are not assigned to any sections.");
            return;
        }

        System.out.println("Sections assigned to you:");
        for (int i = 0; i < sections.size(); i++) {
            Section section = sections.get(i);
            Course course = section.course;
            System.out.println((i + 1) + ": " + course.name + "." + section.number);
        }

        System.out.println("Select a section to view students (0 to go back):");
        int sectionNumber = Session.getSession().inputScanner.nextInt();
        Session.getSession().inputScanner.nextLine();

        if (sectionNumber == 0 || sectionNumber < 1 || sectionNumber > sections.size()) {
            return;
        }

        Section selectedSection = sections.get(sectionNumber - 1);

        System.out.println("Students in " + selectedSection.course.name + "." + selectedSection.number + ":");
        for (int i = 0; i < selectedSection.students.size(); i++) {
            Student student = selectedSection.students.get(i);
            System.out.println((i + 1) + ": " + student.name);
        }
    }

    private void removeStudent() {
        System.out.println("Select a course section to remove a student from:");
        for (int i = 0; i < sections.size(); i++) {
            Section section = sections.get(i);
            Course course = section.course;
            System.out.println((i + 1) + ": " + course.name + "." + section.number);
        }

        int sectionNumber = Session.getSession().inputScanner.nextInt();
        Session.getSession().inputScanner.nextLine();

        if (sectionNumber < 1 || sectionNumber > sections.size()) {
            System.out.println("Invalid section number.");
            return;
        }

        Section selectedSection = sections.get(sectionNumber - 1);

        if (selectedSection.students.isEmpty()) {
            System.out.println("No students to remove in this section.");
            return;
        }

        System.out.println("Select a student to remove from the section:");
        for (int i = 0; i < selectedSection.students.size(); i++) {
            Student student = selectedSection.students.get(i);
            System.out.println((i + 1) + ": " + student.name);
        }

        int studentNumber = Session.getSession().inputScanner.nextInt();
        Session.getSession().inputScanner.nextLine();

        if (studentNumber < 1 || studentNumber > selectedSection.students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        Student removedStudent = selectedSection.students.remove(studentNumber - 1);
        System.out.println("Removed student: " + removedStudent.name);
    }
}

class TA extends User implements Action {
    public String taId;
    public ArrayList<Section> sections = new ArrayList<Section>();
    public TA(){
    }
    public TA(String email,String password, String name, String taId) {
        super(email, password, name);
        this.taId = taId;
    }

    @Override
    public void handleActions() {
        while (true) {
            System.out.println("1: View Courses 2: Logout");
            int action = Session.getSession().inputScanner.nextInt();
            Session.getSession().inputScanner.nextLine();

            if (action == 1) {
                viewCourses();
            } else if (action == 2) {
                break;
            }
        }
    }

    private void viewCourses() {
        if (sections.isEmpty()) {
            System.out.println("You are not assigned to any sections.");
            return;
        }

        System.out.println("Sections assigned to you:");
        for (int i = 0; i < sections.size(); i++) {
            Section section = sections.get(i);
            Course course = section.course;
            System.out.println((i + 1) + ": " + course.name + "." + section.number);
        }

        System.out.println("Select a section to view students (0 to go back):");
        int sectionNumber = Session.getSession().inputScanner.nextInt();
        Session.getSession().inputScanner.nextLine();

        if (sectionNumber == 0 || sectionNumber < 1 || sectionNumber > sections.size()) {
            return;
        }

        Section selectedSection = sections.get(sectionNumber - 1);

        System.out.println("Students in " + selectedSection.course.name + "." + selectedSection.number + ":");
        for (int i = 0; i < selectedSection.students.size(); i++) {
            Student student = selectedSection.students.get(i);
            System.out.println((i + 1) + ": " + student.name);
        }
    }
}

class Course {
    public String name;
    public int number;
    public int startTime;
    public int endTime;
    public Course(){
    }
    public Course(String name, int number, int startTime, int endTime) {
        this.name = name;
        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Section {
    public Course course;
    public int number;
    public Teacher teacher;
    public TA ta;
    public ArrayList<Student> students = new ArrayList<Student>();
    public Section(){
    }
    public Section(Course course, int number, Teacher teacher, TA ta) {
        this.course = course;
        this.number = number;
        this.teacher = teacher;
        this.ta = ta;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
}

class Session {
    private static Session session = null;
    private User userList[] = new User[7];
    private Course courseList[] = new Course[6];
    public Scanner inputScanner = new Scanner(System.in);

    private Session() {
        createDatabase();
    }

    private void createDatabase() {
        userList[0] = new Student("student_a@northsouth.edu", "password", "A", "S1", 3.4);
        userList[1] = new Student("student_b@northsouth.edu", "password", "B", "S2", 3.6);
        userList[2] = new Student("student_c@northsouth.edu", "password", "C", "S3", 3.2);

        userList[3] = new Teacher("teacher_a@northsouth.edu", "password", "A", "T1");
        userList[4] = new Teacher("teacher_b@northsouth.edu", "password", "B", "T2");

        userList[5] = new TA("assistant_a@northsouth.edu", "password", "A", "A1");
        userList[6] = new TA("assistant_b@northsouth.edu", "password", "B", "A2");

        courseList[0] = new Course("Course A", 1, 8, 10);
        courseList[1] = new Course("Course A", 2, 10, 12);
        courseList[2] = new Course("Course A", 3, 14, 16);
        courseList[3] = new Course("Course B", 1, 8, 10);
        courseList[4] = new Course("Course C", 1, 10, 12);
        courseList[5] = new Course("Course C", 2, 14, 16);

        Section section1 = new Section(courseList[0], 1, (Teacher) userList[3], (TA) userList[5]);
        Section section2 = new Section(courseList[1], 2, (Teacher) userList[4], (TA) userList[5]);
        Section section3 = new Section(courseList[2], 3, (Teacher) userList[3], (TA) userList[6]);
        Section section4 = new Section(courseList[3], 1, (Teacher) userList[3], (TA) userList[5]);
        Section section5 = new Section(courseList[4], 1, (Teacher) userList[4], (TA) userList[5]);
        Section section6 = new Section(courseList[5], 2, (Teacher) userList[3], (TA) userList[6]);

        ((Teacher) userList[3]).sections.add(section1);
        ((Teacher) userList[4]).sections.add(section2);
        ((Teacher) userList[3]).sections.add(section3);
        ((Teacher) userList[3]).sections.add(section4);
        ((Teacher) userList[4]).sections.add(section5);
        ((Teacher) userList[3]).sections.add(section6);

        ((TA) userList[5]).sections.add(section1);
        ((TA) userList[5]).sections.add(section2);
        ((TA) userList[6]).sections.add(section3);
        ((TA) userList[5]).sections.add(section4);
        ((TA) userList[5]).sections.add(section5);
        ((TA) userList[6]).sections.add(section6);

        section1.addStudent((Student) userList[0]);
        section1.addStudent((Student) userList[1]);
        section1.addStudent((Student) userList[2]);
        section2.addStudent((Student) userList[0]);
        section2.addStudent((Student) userList[1]);
        section2.addStudent((Student) userList[2]);
        section3.addStudent((Student) userList[0]);
        section3.addStudent((Student) userList[1]);
        section3.addStudent((Student) userList[2]);
        section4.addStudent((Student) userList[0]);
        section4.addStudent((Student) userList[1]);
        section4.addStudent((Student) userList[2]);
        section5.addStudent((Student) userList[0]);
        section5.addStudent((Student) userList[1]);
        section5.addStudent((Student) userList[2]);
        section6.addStudent((Student) userList[0]);
        section6.addStudent((Student) userList[1]);
        section6.addStudent((Student) userList[2]);
    }

    public static Session getSession() {
        if (session == null)
            session = new Session();
        return session;
    }

    public Course[] getCourseList() {
        return courseList;
    }

    public User[] getUserList() {
        return userList;
    }
}

interface Action {
    public void handleActions();
}

public class CourseManagement {
    public static void main(String[] args) {
        while (true) {
            Session session = Session.getSession();

            System.out.print("Email: ");
            String email = session.inputScanner.nextLine();
            System.out.print("Password: ");
            String password = session.inputScanner.nextLine();

            try{
                User user = login(email, password);
                if (user instanceof Student) {
                    Student student = (Student) user;
                    student.handleActions();
                } else if (user instanceof Teacher) {
                    Teacher teacher = (Teacher) user;
                    teacher.handleActions();
                } else if (user instanceof TA) {
                    TA ta = (TA) user;
                    ta.handleActions();
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static User login(String email, String password) throws Exception {
        Session session = Session.getSession();
        User[] userList = session.getUserList();

        for (User user : userList) {
            if (user != null && user.email.equals(email) && user.password.equals(password)) {
                return user;
            }
        }
        throw new Exception("User not found");
    }
}