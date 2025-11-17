package W47Polymorphism;

class Human {
    String name;

    public Human(String name) {
        this.name = name;
        System.out.println("Human constructor: " + name);

    }

    void doStuff () {
        System.out.println("Human do stuff: " + name);
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Student extends Human {
    public Student(String name) {
        super(name);
    }

    @Override
    void doStuff () {
        study();
    }

    void study() {
        System.out.println("Student studies");
    }
}

class Teacher extends Human {
    public Teacher(String name) {
        super(name);
        System.out.println("Teacher constructor: " + name);
    }

    @Override
    void doStuff() {
        teach();
    }

    void teach() {
        System.out.println("Teacher teaches");
    }
}


public class Polymorphism1 {
    public static void main(String[] args) {
        Human bea = new Teacher("Bea");
        bea.doStuff();

        Human hisham = new Student("Hisham");
        hisham.doStuff();
    }
}
