package W46Composition;
import java.util.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    float averageGrade;

    public Student(String name, int age) {
        super(name, age);
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }
}

class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }
}

class Class {
    protected String courseName;
    private List<Student> students;
    protected Teacher teacher;

    public Class(String courseName, List<Student> students, Teacher teacher) {
        this.courseName = courseName;
        this.students = students;
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}

public class Composition1 {
    public static void main(String[] args) {
        // create teacher
        Teacher bea = new Teacher("Bea", 5);

        // create students
        Student s1 = new Student("Linnea", 18);
        Student s2 = new Student("Anton", 21);
        Student s3 = new Student("Priya", 19);
        Student s4 = new Student("Paul", 22);

        // put them in list
        List<Student> cse_students = new ArrayList<Student>();
        cse_students.add(s1);
        cse_students.add(s2);
        cse_students.add(s3);
        cse_students.add(s4);

        // create class for course
        Class DIT044H25 = new Class("DIT044H25", cse_students, bea);
    }
}