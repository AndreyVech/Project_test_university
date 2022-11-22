package org.example;

import org.example.model.Student;
import org.example.sourse.JsonUtils;

import static org.example.enums.StudyProfile.*;
import static org.example.printForm.PrintDefault.*;
import static org.example.printForm.PrintFromFile.*;
import static org.example.printForm.PrintFromFileWithCompare.*;
import static org.example.printForm.PrintJson.*;
import static org.example.sourse.FileUtils.loadStudentsFromFile;
import static org.example.sourse.FileUtils.loadUniversitiesFromFile;

public class Main {
    public static void main(String[] args) {
        String f = "C:/Users/icq80/IdeaProjects/Project_test_university/src/main/resources/universityInfo.xlsx";

//вручную создаем объекты и выводим в консоль
//        printDefaultStudent("0001-high", 2, "Иванов В.В.", (float) 4.2);
//        printDefaultUniversity("0001-high", 2002, "Это первый университет", "ЭПУ", DESIGNER);


//вычитать из файла и вывести данные
//        printFromFileUniversity(f);
//        printFromFileStudent(f);
//

//Вычитать из файла и вывести с сортировкой
//        Для студентов варианты сортировки строковым значением:
//                Name
//                University
//                Course
//                Score
//        printFromFileWithCompareStudent(f, "SCORE");
//        Для университетов варианты сортировки строковым значением:
//                ID
//                full name
//                short name
//                profile
//                year
//        printFromFileWithCompareUniversity(f, "full name");

//создаем и выводим jsonы
//        printUniversityToJson(f);
//        printUniversityArrToJson(f);
//        printStudentToJson(f);
//        printStudentArrToJson(f);

//читаем jsonы

//        printStudentArrFromJson(f);
//        printUniversityArrFromJson(f);
//        printStudentFromJson(f);
//        printUniversityFromJson(f);


    }
}
