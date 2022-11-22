package org.example.printForm;

import org.example.sourse.JsonUtils;

import static org.example.sourse.FileUtils.loadStudentsFromFile;
import static org.example.sourse.FileUtils.loadUniversitiesFromFile;

public class PrintJson {
    private PrintJson(){}

    public static void printJsonUniversity(String link){
        loadUniversitiesFromFile(link).stream().forEach(JsonUtils::jsonSerializeUniversity);
    }

    public static void printJsonUniversityArr(String link){
        System.out.println(JsonUtils.jsonSerializeUniversityArr(loadUniversitiesFromFile(link)));
    }

    public static void printJsonStudent(String link){
        loadStudentsFromFile(link).stream().forEach(JsonUtils::jsonSerializeStudent);
    }

    public static void printJsonStudentArr(String link){
        System.out.println(JsonUtils.jsonSerializeStudentArr(loadStudentsFromFile(link)));
    }
}
