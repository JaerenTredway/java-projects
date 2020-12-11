public class Student {

    public static final double DEFAULT_GRADE = 100;

    // These are instance variables
    private String name;
    private int id;
    private double grade = DEFAULT_GRADE;

    // This is a class variable
    private static int numberOfStudents = 0;

    public Student(String name) {
        this.name = name;
        // Give each student a unique ID
        this.id = ++numberOfStudents;
    }

    public Student() {
        this("UNKNOWN");
    }

    public void setName(String name) {
        if(name == null) {
            System.out.println("Ignoring null name");
        } else if(name.isEmpty()) {
            System.out.println("Ignoring empty name");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if(grade < 0) {
            System.out.println("Ignoring negative grade");
        } else {
            this.grade = grade;
        }
    }

    public String toString() {
        return "Student: name = " + name + ", id = " + id;
    }

    public String toVerboseString() {
        return "Student: name = " + name + ", id = " + id + ", grade = " + grade;
    }

    public String toPrettyString() {
        return name + " has grade " + grade;
    }

    public static Student findHighestGrade(Student[] arr) {
        Student best = null;
        for(Student s : arr) {
            if(best == null || best.grade < s.grade) {
                best = s;
            }
        }
        return best;
    }

    public static void main(String[] args) {

        System.out.println("num students before = " + numberOfStudents);

        Student a = new Student("Bob");
        Student b = new Student("Jane");

        System.out.println("num students after = " + numberOfStudents);

        System.out.println(a.toString());
        System.out.println(b);
        System.out.println(a);

        System.out.println("make another student");
        Student c = new Student();
        System.out.println(c.toString());
        System.out.println(c);

        System.out.println("change name");
        c.setName("George");
        System.out.println(c);

        System.out.println(a.toString());
        System.out.println(a.toVerboseString());
        System.out.println(a.toPrettyString());

        a.setGrade(97);
        b.setGrade(95);
        c.setGrade(83.2);

        Student[] students = {a, b, new Student("NewGuy"), c};

        for(int i = 0; i < students.length; i++) {
            System.out.println(students[i].toVerboseString());
        }

        System.out.println("find best grade");
        System.out.println(findHighestGrade(students).toPrettyString());
    }
}
