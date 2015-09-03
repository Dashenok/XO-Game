package io.hexlet.java.m101.xo;


import lists.*;
import lists.ArrayLists;


import java.util.*;;


public class Main {

    public static void main(String[] args) {
        final University univ = new University("name", "address");
        test1(univ);
        test2();
        test3(univ);
    }
    private static void test1(final University univ) {
        if (!univ.getName().equals("name")) {
            throw new RuntimeException(String.format("University name is incorrectly set, expected: \"%s\", actual: \"%s\"", "name", univ.getName()));
        }
        if (!univ.getAddress().equals("address")) {
            throw new RuntimeException(String.format("University address is incorrectly set, expected: \"%s\", actual: \"%s\"", "address", univ.getAddress()));
        }
    }

    private static void test2() {
        final University.Student student = new University.Student("Max", 2);
        if (!student.toString().equals("name: Max, grade: 2")) {
            throw new RuntimeException(String.format("Student du not return correct toString, expected: \"%s\", actual: \"%s\"", "name: Max, grade: 2.0", student.toString()));
        }
        if (!student.getName().equals("Max")) {
            throw new RuntimeException(String.format("Stundent name is incorrectly set, expected: \"%s\", actual: \"%s\"", "Max", student.getName()));
        }
        if (!((Integer)(student.getGrade())).equals(2)) {
            throw new RuntimeException(String.format("Stundent grade is incorrectly set, expected: \"%d\", actual: \"%d\"", 2, student.getGrade()));
        }
    }

    private static void test3(final University univ) {
        final List<University.Student> students = (List<University.Student>)univ.getStudentsList();
        students.add(new University.Student("Max", 2));
    }





}
