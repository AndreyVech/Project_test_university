package org.example.printForm;

import org.example.enums.StudyProfile;
import org.example.model.*;

import java.util.List;

public class PrintDefault {
    private PrintDefault() {
    }

    public static void printStudents(List<Student> students) {
        students.forEach(System.out::println);
    }

    public static void printUniver(List<University> universities) {
        universities.forEach(System.out::println);
    }


    public static void printDefaultStudent(String universityId, int currentCourseNumber, String fullName, Float avgExamScore) {
        Student student = new Student();
        System.out.println(
                student.setAvgExamScore(avgExamScore)
                        .setFullName(fullName)
                        .setCurrentCourseNumber(currentCourseNumber)
                        .setUniversityId(universityId)
        );
    }

    public static void printDefaultUniversity(String id, int year, String fullName, String shortName, Enum profile) {
        University university = new University();
        System.out.println(
                university.setId(id)
                        .setFullName(fullName)
                        .setMainProfile((StudyProfile) profile)
                        .setShortName(shortName)
                        .setYearOfFoundation(year)
        );
    }
}
