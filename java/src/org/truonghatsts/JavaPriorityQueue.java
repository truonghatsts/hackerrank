package org.truonghatsts;

import java.util.*;

/**
 * @author Fenix truonghatsts@gmail.com
 */

class Priorities {

    private PriorityQueue<Student> queue = new PriorityQueue<Student>();

    public List<Student> getStudents(List<String> events) {

        for (String event : events) {
            if (event.startsWith("ENTER")) {
                String[] tokens = event.split(" ");
                String name = tokens[1];
                double cgpa = Double.parseDouble(tokens[2]);
                int id = Integer.parseInt(tokens[3]);
                queue.add(new Student(id, name, cgpa));
            } else {
                queue.poll();
            }
        }

        ArrayList<Student> students = new ArrayList<>(queue);
        Collections.sort(students);
        return students;
    }
}

class Student implements Comparable<Student> {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
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

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student student) {
        if (this.getCgpa() == student.getCgpa()) {
            if (this.getName().equals(student.getName())) {
                return this.getId() - student.getId();
            } else {
                return this.getName().compareTo(student.getName());
            }
        } else {
            return student.getCgpa() > this.getCgpa() ? 1 : -1;
        }
    }
}

public class JavaPriorityQueue {

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
