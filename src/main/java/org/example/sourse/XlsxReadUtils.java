package org.example.sourse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.model.Student;
import org.example.model.University;

import java.io.*;
import java.util.*;

public class XlsxReadUtils {
    private XlsxReadUtils(){};

    public static List<Student> loadStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        XSSFWorkbook workBook = null;
        try {
            workBook = new XSSFWorkbook(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Row> rowIterator = workBook.getSheet("Студенты").iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            String studentString = "";
            Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case STRING:
                        String str1 = cell.getStringCellValue();
                        studentString = studentString.concat(str1 + ";");
                        break;
                    case NUMERIC:
                        String str2 = NumberToTextConverter.toText(cell.getNumericCellValue());
                        studentString = studentString.concat(str2 + ";");
                        break;
                }
            }
            students.add(parseStudent(studentString));
        }
        return students;
    }


    private static Student parseStudent(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        String universityId = scanner.next();
        String fullName = scanner.next();
        int currentCourseNumber = Integer.parseInt(scanner.next());
        float avgExamScore = Float.parseFloat(scanner.next());
        scanner.close();

        return new Student(fullName, universityId, currentCourseNumber, avgExamScore);
    }

    public static List<University> loadUniversitiesFromFile(String fileName) {
        List<University> universities = new ArrayList<>();
        XSSFWorkbook workBook = null;
        try {
            workBook = new XSSFWorkbook(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Row> rowIterator = workBook.getSheet("Университеты").iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            String univerString = "";
            Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case STRING:
                        String str1 = cell.getStringCellValue();
                        univerString = univerString.concat(str1 + ";");
                        break;
                    case NUMERIC:
                        String str2 = NumberToTextConverter.toText(cell.getNumericCellValue());
                        univerString = univerString.concat(str2 + ";");
                        break;
                }
            }
            universities.add(parseUniver(univerString));
        }
        return universities;
    }


    private static University parseUniver(String line) {
        int wordsCnt = line.split(";").length;
        String universityId = null;
        String fullName = null;
        String shortName = null;
        int yearOfFoundation = 0;
        StudyProfile mainProfile = null; 
        for (int i = 0; i < wordsCnt; i++) {
            switch (i) {
                case 0:
                    universityId = line.split(";")[i];
                    break;
                case 1:
                    fullName = line.split(";")[i];
                    break;
                case 2:
                    shortName = line.split(";")[i];
                    break;
                case 3:
                    yearOfFoundation = Integer.parseInt(line.split(";")[i]);
                    break;
                case 4:
                    String mainProfileString = line.split(";")[i];
                    mainProfile = StudyProfile.valueOf(mainProfileString.toUpperCase(Locale.ENGLISH));
                    break;
                default:
                    i = i;
            }
        }
        return new University(universityId, fullName, shortName, yearOfFoundation, mainProfile);
    }
}