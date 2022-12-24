package org.example.printToConsole;

import org.example.model.Student;
import org.example.model.University;
import org.example.source.JsonWrite.JsonUtils;

import static org.example.source.XlsxReadUtils.loadStudentsFromFile;
import static org.example.source.XlsxReadUtils.loadUniversitiesFromFile;

public class PrintJson {
    private PrintJson() {
    }

    public static void printUniversityToJson(String link) {
        loadUniversitiesFromFile(link).stream().forEach(university -> {
                    String universityJson = JsonUtils.jsonSerializeUniversity(university);
                    System.out.println(universityJson);
                }
        );
    }

    public static void printUniversityArrToJson(String link) {
        System.out.println(JsonUtils.jsonSerializeUniversityArr(loadUniversitiesFromFile(link)));
    }

    public static void printStudentToJson(String link) {
        loadStudentsFromFile(link).stream().forEach(student -> {
                    String studentJson = JsonUtils.jsonSerializeStudent(student);
                    System.out.println(studentJson);
                }
        );
    }

    public static void printStudentArrToJson(String link) {
        System.out.println(JsonUtils.jsonSerializeStudentArr(loadStudentsFromFile(link)));
    }

    public static void printStudentArrFromJson(String link) {
        JsonUtils.jsonUnserializeStudentArr(JsonUtils.jsonSerializeStudentArr(loadStudentsFromFile(link))).stream().forEach(System.out::println);
    }

    public static void printUniversityArrFromJson(String link) {
        JsonUtils.jsonUnserializeUniversityArr(JsonUtils.jsonSerializeUniversityArr(loadUniversitiesFromFile(link))).stream().forEach(System.out::println);
    }

    public static void printStudentFromJson(String link) {
        loadStudentsFromFile(link).stream().forEach(student -> {
                    String studentJson = JsonUtils.jsonSerializeStudent(student);
                    Student studentFromJson = JsonUtils.jsonUnserializeStudent(studentJson);
                    System.out.println(studentFromJson);
                }
        );
    }

    public static void printUniversityFromJson(String link) {
        loadUniversitiesFromFile(link).stream().forEach(university -> {
                    String universityJson = JsonUtils.jsonSerializeUniversity(university);
                    University universityFromJson = JsonUtils.jsonUnserializeUniversity(universityJson);
                    System.out.println(universityFromJson);
                }
        );
    }


}
