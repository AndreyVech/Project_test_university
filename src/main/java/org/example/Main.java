package org.example;

import org.example.comparator.utils.ComparatorUtils;
import org.example.enums.ComparatorTypeStudent;
import org.example.enums.ComparatorTypeUniversity;
import org.example.printForm.PrintDefault;
import org.example.printForm.PrintFromFile;
import org.example.printForm.PrintFromFileWithCompare;

import static org.example.enums.StudyProfile.*;
import static org.example.sourse.FileUtils.*;

public class Main {
    public static void main(String[] args) {
        String f = "C:/Users/icq80/IdeaProjects/Project_test_university/src/main/resources/universityInfo.xlsx";

////вручную создаем объекты и выводим в консоль
//        PrintDefault.printDefaultStudent("0001-high", 2, "Иванов В.В.", (float) 4.2);
//        PrintDefault.printDefaultUniversity("0001-high", 2002, "Это первый университет", "ЭПУ", DESIGNER);


////вычитать из файла и вывести данные
//        PrintFromFile.printFromFileUniversity(f);
//        PrintFromFile.printFromFileStudent(f);



//Вычитать из файла и вывести с сортировкой
//        Для студентов варианты сортировки строковым значением:
    //        Name
    //        University
    //        Course
    //        Score
        PrintFromFileWithCompare.printFromFileWithCompareStudent(f, "SCORE");
//        Для университетов варианты сортировки строковым значением:
        //        ID
        //        full name
        //        short name
        //        profile
        //        year
        PrintFromFileWithCompare.printFromFileWithCompareUniversity(f, "ID");
    }
}
