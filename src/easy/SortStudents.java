package easy;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class SortStudents {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList = studentList.stream().sorted(Comparator.comparingDouble(Student::getCgpa).reversed()
                                                            .thenComparing(Student::getFname)
                                                            .thenComparing(Student::getId))
                                 .collect(Collectors.toList());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
    public static void reflectionSolution(){
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method:methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}



