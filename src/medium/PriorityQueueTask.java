package medium;

import java.util.*;
import java.util.stream.Collectors;

public class PriorityQueueTask {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

}

class Priorities {
    List<Student> getStudents(List<String> events) {
        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int cgpaCompare = Double.compare(s2.getCGPA(), s1.getCGPA());
                int nameCompare = s1.getName().compareTo(s2.getName());
                if (cgpaCompare != 0) {
                    return cgpaCompare;
                } else if (nameCompare != 0) {
                    return nameCompare;
                } else {
                    return Integer.compare(s2.getId(), s1.getId());
                }


            }
        };
        List<Student> pq = new ArrayList<>();
        for (String event : events) {
            String[] input = event.split("\\s");
            if (input[0].equals("ENTER")) {
                String name = input[1];
                double cgpa = Double.parseDouble(input[2]);
                int id = Integer.parseInt(input[3]);
                pq.add(new Student(id, name, cgpa));
                pq = pq.stream().sorted(studentComparator).collect(Collectors.toList());
            } else {
                if(pq.size()>0){
                    pq.remove(0);
                }

            }
        }

        return pq.stream().sorted(studentComparator).collect(Collectors.toList());
    }

}

