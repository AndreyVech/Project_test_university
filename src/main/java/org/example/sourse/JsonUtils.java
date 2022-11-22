package org.example.sourse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Student;
import org.example.model.University;

import java.util.List;

public class JsonUtils {
    private JsonUtils(){}
    University university;
    Student student;

    public static String jsonSerializeUniversity(University university){
        return new GsonBuilder()
                .setPrettyPrinting()
                .create().toJson(university);
    };

    public static String jsonSerializeUniversityArr(List<University> universities){
        return new GsonBuilder()
                .setPrettyPrinting()
                .create().toJson(universities);
    };

    public static University jsonUnserializeUniversity(String json){
        return new Gson().fromJson(json, University.class);
    };

    public static List<University> jsonUnserializeUniversityArr(String json){
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    };

    public static String jsonSerializeStudent(Student student){
        return new GsonBuilder()
                .setPrettyPrinting()
                .create().toJson(student);
    };

    public static String jsonSerializeStudentArr(List<Student> students){
        return new GsonBuilder()
                .setPrettyPrinting()
                .create().toJson(students);
    };

    public static Student jsonUnserializeStudent(String json){
        return new Gson().fromJson(json, Student.class);
    };

    public static List<Student> jsonUnserializeStudentArr(String json){
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    };


}
