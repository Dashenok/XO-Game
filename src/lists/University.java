package lists;

import java.util.*;

public class University {
    // BEGIN
    final String name;
    final String address;

    List<Student> listOfStudents = new ArrayList<Student>();

    public University(final String name, final String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public List getStudentsList(){
        return listOfStudents;
    }

    public void showAllStudents() {

        for (Student s : listOfStudents) {
            System.out.println(s.toString());

        }
    }

         public static class Student{

            final String name;
            final int grade;

            public Student(final String name, final int grade){
                this.name = name;
                this.grade = grade;
            }
            @Override
            public String toString(){
                return String.format("name: %s, grade: %d", name, grade);
            }

            public String getName(){
                return name;
            }

            public int getGrade(){
                return grade;
            }

        }

        // END
}