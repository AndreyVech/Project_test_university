package org.example;

import org.example.model.Student;
import org.example.model.University;
import org.example.sourse.FileUtils;

import static org.example.enums.StudyProfile.*;
import static org.example.sourse.FileUtils.*;

public class Main {
    public static void main(String[] args) {
        String f = "C:/Users/icq80/IdeaProjects/Project_test_university/src/main/resources/universityInfo.xlsx";
//вручную создаем объекты и выводим в консоль
//        university1.setId("0001/A")
//                .setFullName("Some Technical University")
//                .setShortName("STU")
//                .setYearOfFoundation(1985)
//                .setMainProfile(designer);
//
//        student1.setAvgExamScore((float) 2.2)
//                .setFullName("Пукин В.В.")
//                .setCurrentCourseNumber(4)
//                .setUniversityId("0001-high");
//        System.out.println(university1);
//        System.out.println(student1);
        printStudents(loadStudentsFromFile(f));
        printUniver(loadUniversitiesFromFile(f));

    }
}