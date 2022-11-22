package org.example.printForm;

import org.example.comparator.utils.ComparatorUtils;
import org.example.enums.*;

import static org.example.sourse.FileUtils.*;

public class PrintFromFileWithCompare {
    private PrintFromFileWithCompare(){}

    public static void printFromFileWithCompareStudent(String link, String typeCompare) {
        Enum compareType;
        switch (typeCompare.toLowerCase()){
            case "score": compareType = ComparatorTypeStudent.AVG_EXAM_SCORE;
                break;
            case "name": compareType = ComparatorTypeStudent.FULL_NAME;
                break;
            case "university": compareType = ComparatorTypeStudent.UNIVERSITY_ID;
                break;
            case "course": compareType = ComparatorTypeStudent.COURSE;
                break;
            default: compareType = ComparatorTypeStudent.FULL_NAME;
        }
        loadStudentsFromFile(link).stream().sorted(ComparatorUtils.getStudentComparator((ComparatorTypeStudent) compareType))
        .forEach(System.out::println);
    };

    public static void printFromFileWithCompareUniversity(String link, String typeCompare) {
        Enum compareType;
        switch (typeCompare.toLowerCase()){
            case "full name": compareType = ComparatorTypeUniversity.FULL_NAME;
                break;
            case "short name": compareType = ComparatorTypeUniversity.SHORT_NAME;
                break;
            case "id": compareType = ComparatorTypeUniversity.ID;
                break;
            case "profile": compareType = ComparatorTypeUniversity.PROFILE;
                break;
            case "year": compareType = ComparatorTypeUniversity.YEAR;
                break;
            default: compareType = ComparatorTypeUniversity.ID;
        }
        loadUniversitiesFromFile(link).stream().sorted(ComparatorUtils.getUniversityComparator((ComparatorTypeUniversity) compareType))
                .forEach(System.out::println);
    }
}
