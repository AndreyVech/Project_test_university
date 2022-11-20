package org.example.printForm;
import org.example.enums.StudyProfile;
import org.example.model.*;

public class PrintDefault {
    public PrintDefault(){}

    public static PrintDefault printDefaultStudent(String universityId, int currentCourseNumber, String fullName, Float avgExamScore) {
        Student student = new Student();
        System.out.println(
                student.setAvgExamScore(avgExamScore)
                        .setFullName(fullName)
                        .setCurrentCourseNumber(currentCourseNumber)
                        .setUniversityId(universityId)
        );
        return null;
    }

    public static PrintDefault printDefaultUniversity(String id, int year, String fullName, String shortName, Enum profile) {
        University university = new University();
        System.out.println(
                university.setId(id)
                        .setFullName(fullName)
                        .setMainProfile((StudyProfile) profile)
                        .setShortName(shortName)
                        .setYearOfFoundation(year)
        );
        return null;
    }
}
