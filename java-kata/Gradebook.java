public class Gradebook {

    public static final int DEFAULT_CAPACITY = 25;

    private Student[] students;
    private int numStudents;

    public Gradebook(int capacity) {
        students = new Student[capacity];
        numStudents = 0;
    }

    public Gradebook() {
        this(DEFAULT_CAPACITY);
    }

    public String toString() {
        String result = "";
        for(int i = 0; i < numStudents; i++) {
            result += i + ". " + students[i].toVerboseString() + "\n";
        }
        return result;
    }

    public void addStudent(Student s) {
//        if(numStudents < students.length) {
//            students[numStudents] = s;
//            numStudents++;
//        } else {
//            System.out.println("Cannot add student " + s.getName() + ", gradebook is full");
//        }

        if(numStudents == students.length) {
            expandArray();
        }

        students[numStudents] = s;
        numStudents++;
    }

    private void expandArray() {
        System.out.println("expanding array");
        Student[] newArray = new Student[students.length * 2];
        for(int i = 0; i < students.length; i++) {
            newArray[i] = students[i];
        }
        students = newArray;
    }

    public double getAverageGrade() {
        double sum = 0;
        for(int i = 0; i < numStudents; i++) {
            sum += students[i].getGrade();
        }
        return numStudents == 0 ? 0 : sum/numStudents;
    }

    public String getPassingStudents(double threshold) {
        String result = "";
        for(int i = 0; i < numStudents; i++) {
            if(students[i].getGrade() >= threshold) {
                result += i + ". " + students[i].toVerboseString() + "\n";
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return numStudents == 0;
    }

    public int getSize() {
        return numStudents;
    }

    public Student getStudent(int index) {
        if(index < 0 || index >= numStudents) {
            return null;
        } else {
            return students[index];
        }
    }

    public void removeStudent(int index) {
        for(int i = index; i < numStudents-1; i++) {
            students[i] = students[i+1];
        }
        numStudents--;
        students[numStudents] = null;
    }

    public void removeStudent(String name) {
        int index = findStudent(name);
        if(index < 0) {
            System.out.println("Could not find " + name);
        } else {
            removeStudent(index);
        }
    }

    /**
     * Find a student by name
     * @param name Name of student we seek
     * @return Index of first student with name, or -1 if not found.
     */
    public int findStudent(String name) {
        int index = -1;
        for(int i = 0; i < numStudents; i++) {
            if(students[i].getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Gradebook g = new Gradebook(3);

        Student s1 = new Student("Jane");
        s1.setGrade(90);
        Student s2 = new Student("Bob");
        s2.setGrade(89);

        g.addStudent(s2);
        g.addStudent(s1);

        for(int i = 0; i < 5; i++) {
            Student s = new Student("New Student " + i);
            s.setGrade(Math.random()*50 + 50);
            g.addStudent(s);
        }

        System.out.println(g);
        System.out.println("Average grade is " + g.getAverageGrade());

        System.out.println("Passing students");
        System.out.println(g.getPassingStudents(75));

        int n = 3;
        System.out.println("student at index " + n + " is " + g.getStudent(n));

        System.out.println("remove student at " + n);
        g.removeStudent(n);

        System.out.println(g);

        String name = "Bob";
        System.out.println("Student with name " + name + " is at " + g.findStudent(name));
        name = "Joe";
        System.out.println("Student with name " + name + " is at " + g.findStudent(name));
        name = "New Student 3";
        System.out.println("Student with name " + name + " is at " + g.findStudent(name));

        System.out.println("remove " + name);
        g.removeStudent(name);
        System.out.println(g);
    }
}
