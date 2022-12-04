package org.example;

import org.example.source.xlsxWriteUtils.XlsxWrite;

import java.io.IOException;
import java.util.logging.*;

import static org.example.printForm.PrintFromFileWithCompare.printFromFileWithCompareUniversity;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String f = "C:/Users/icq80/IdeaProjects/Project_test_university/src/main/resources/universityInfo.xlsx";

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (
                IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        logger.log(Level.INFO, "Старт");


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

//        new XlsxWrite(f, true, false); //только с первой страницей
        new XlsxWrite(f, true, true); //обе страницы
//        new XlsxWrite(f, false, true); //только вторая страницы
    }
}
