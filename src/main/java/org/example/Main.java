package org.example;

import org.example.comparatorIn.utils.ComparatorUtils;
import org.example.enums.ComparatorTypeStudent;
import org.example.enums.ComparatorTypeUniversity;
import org.example.model.FullModel;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.source.xlsxWrite.XlsxWrite;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.example.source.JsonWrite.WriteJson.createJson;
import static org.example.source.XlsxReadUtils.loadStudentsFromFile;
import static org.example.source.XlsxReadUtils.loadUniversitiesFromFile;
import static org.example.source.XmlWrite.WriteXml.createXml;
import static org.example.source.xlsxWrite.XlsxStatisticsUtil.createStatList1;

//        "C:/Users/icq80/IdeaProjects/Project_test_university/src/main/resources/universityInfo.xlsx";

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void logger() {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (
                IOException e) {
            System.err.println("Could not setup logger configuration: " + e);
        }
        logger.log(Level.INFO, "Process start");
    }

    public static void main(String[] args) {
        logger();
        String link = JOptionPane.showInputDialog("Введите ссылку на файл");

        List<Student> students = loadStudentsFromFile(link);
        students.sort(ComparatorUtils.getStudentComparator(ComparatorTypeStudent.AVG_EXAM_SCORE));
        List<University> universities = loadUniversitiesFromFile(link);
        universities.sort(ComparatorUtils.getUniversityComparator(ComparatorTypeUniversity.PROFILE));

        //создаем xlsx файл отчета
        new XlsxWrite(true, true, students, universities);

//еще раз пересоберем статистику для сообщений, потому что возможно xlsx и сообщения будут раздельно
        List<Statistics> statisticsList = createStatList1(students, universities);

//создаем json файлы
        createJson(new FullModel().
                setStudentList(students).
                setUniversityList(universities).
                setStatisticsList(statisticsList).
                setDate(new Date()));

//создаем xml файлы
        createXml(new FullModel().
                setStudentList(students).
                setUniversityList(universities).
                setStatisticsList(statisticsList).
                setDate(new Date()));

        logger.log(Level.INFO, "Process finished");
    }
}

