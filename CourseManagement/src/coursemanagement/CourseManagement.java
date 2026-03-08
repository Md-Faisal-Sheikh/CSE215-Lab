package coursemanagement;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean login(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void viewCourses(ArrayList<Course> courses) {
        // Implement course viewing logic
        // Display the list of available courses
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}

class Student extends User {
    private String studentID;
    private double CGPA;
    ArrayList<Course> enrolledCourses;

    public Student(String email, String password, String studentID, double CGPA) {
        super(email, password);
        this.studentID = studentID;
        this.CGPA = CGPA;
        this.enrolledCourses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        // Implement course addition logic
        if (!enrolledCourses.contains(course) && course.getStudents().size() < 5) {
            enrolledCourses.add(course);
            course.addStudent(this);
        } else {
            System.out.println("Cannot enroll in this course.");
        }
    }

    public void removeCourse(Course course) {
        // Implement course removal logic
        enrolledCourses.remove(course);
        course.removeStudent(this);
    }

    public void viewEnrolledCourses() {
        System.out.println("Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println(course);
        }
    }
}

class Teacher extends User {
    private String teacherID;
    private boolean isTeacher;

    public Teacher(String email, String password, String teacherID, boolean isTeacher) {
        super(email, password);
        this.teacherID = teacherID;
        this.isTeacher = isTeacher;
    }

    public void removeStudent(Student student, Course course) {
        // Implement student removal logic
        if (course.getTeacher().equals(this)) {
            course.removeStudent(student);
        } else {
            System.out.println("You are not the teacher for this course.");
        }
    }

    public void viewStudents(Course course) {
        // Implement student viewing logic
        if (course.getTeacher().equals(this)) {
            ArrayList<Student> students = course.getStudents();
            System.out.println("Students in " + course.getCourseName() + ":");
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("You are not the teacher for this course.");
        }
    }
}

class Course {
    private String courseName;
    private int section;
    private String timing;
    private Teacher teacher;
    private ArrayList<Student> students;

    public Course(String courseName, int section, String timing, Teacher teacher) {
        this.courseName = courseName;
        this.section = section;
        this.timing = timing;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public String toString() {
        return courseName + " (Section " + section + ")";
    }
}

class Session {
    private static Session session = null;
    private ArrayList<User> userList;
    private ArrayList<Course> courseList;
    private Scanner inputScanner;

    private Session() {
        userList = new ArrayList<>();
        courseList = new ArrayList<>();
        inputScanner = new Scanner(System.in);
        createDatabase();
    }

    private void createDatabase() {
        // Populate userList and courseList with sample data
        Teacher teacher1 = new Teacher("teacher_a@northsouth.edu", "password", "T1", true);
        Teacher teacher2 = new Teacher("teacher_b@northsouth.edu", "password", "T2", true);
        Student student1 = new Student("student_a@northsouth.edu", "password", "S1", 3.4);
        Student student2 = new Student("student_b@northsouth.edu", "password", "S2", 3.6);
        Student student3 = new Student("student_c@northsouth.edu", "password", "S3", 3.2);

        Course course1 = new Course("Course A", 1, "A", teacher1);
        Course course2 = new Course("Course A", 2, "A", teacher2);
        Course course3 = new Course("Course A", 3, "B", teacher1);
        Course course4 = new Course("Course B", 1, "D", teacher1);
        Course course5 = new Course("Course C", 1, "B", teacher2);
        Course course6 = new Course("Course C", 2, "C", teacher1);

        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        courseList.add(course5);
        courseList.add(course6);

        userList.add(teacher1);
        userList.add(teacher2);
        userList.add(student1);
        userList.add(student2);
        userList.add(student3);
    }

    public static Session getSession() {
        if (session == null) {
            session = new Session();
        }
        return session;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public Scanner getInputScanner() {
        return inputScanner;
    }
}

public class CourseManagement {
    public static void main(String[] args) {
        while (true) {
            Session session = Session.getSession();

            System.out.print("Email: ");
            String email = session.getInputScanner().nextLine();
            System.out.print("Password: ");
            String password = session.getInputScanner().nextLine();

            User user = login(email, password, session.getUserList());
            if (user != null) {
                userActions(user, session.getCourseList(), session);
            } else {
                System.out.println("User not found.");
            }
        }
    }

    public static User login(String email, String password, ArrayList<User> userList) {
        for (User user : userList) {
            if ((user.login(password) || user instanceof Student || user instanceof Teacher)) {
                return user;
            }
        }
        return null;
    }

    public static void userActions(User user, ArrayList<Course> courseList, Session session) {
        if (user instanceof Student) {
            studentActions((Student) user, courseList, session);
        } else if (user instanceof Teacher) {
            teacherActions((Teacher) user, courseList, session);
        }
    }

    public static void studentActions(Student student, ArrayList<Course> courseList, Session session) {
        while (true) {
            System.out.println("1: Add Course 2: Remove Course 3: View Enrolled Courses 4: Logout");
            int choice = session.getInputScanner().nextInt();
            session.getInputScanner().nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    student.viewCourses(courseList);
                    System.out.print("Index of the Course to be added: ");
                    int courseIndex = session.getInputScanner().nextInt();
                    if (courseIndex >= 0 && courseIndex < courseList.size()) {
                        student.addCourse(courseList.get(courseIndex));
                        System.out.println("You have been enrolled in " + courseList.get(courseIndex).getCourseName() + " Successfully!");
                    }
                    break;
                case 2:
                    student.viewEnrolledCourses();
                    System.out.print("Index of the Course to be removed: ");
                    int courseToRemoveIndex = session.getInputScanner().nextInt();
                    if (courseToRemoveIndex >= 0 && courseToRemoveIndex < student.enrolledCourses.size()) {
                        student.removeCourse(student.enrolledCourses.get(courseToRemoveIndex));
                        System.out.println("You have dropped a course successfully!");
                    }
                    break;
                case 3:
                    student.viewEnrolledCourses();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void teacherActions(Teacher teacher, ArrayList<Course> courseList, Session session) {
        while (true) {
            System.out.println("1: View Courses 2: View Students 3: Logout");
            int choice = session.getInputScanner().nextInt();
            session.getInputScanner().nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    teacher.viewCourses(courseList);
                    break;
                case 2:
                    teacher.viewStudents(courseList.get(0)); // For simplicity, assume the teacher is associated with the first course
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
