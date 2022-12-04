package org.example.printForm;

import static org.example.printForm.PrintDefault.*;
import static org.example.source.XlsxReadUtils.*;

public class PrintFromFile {
    private PrintFromFile(){}

    public static void printFromFileStudent(String link) {
        printStudents(loadStudentsFromFile(link));
    };

    public static void printFromFileUniversity(String link) {
        printUniver(loadUniversitiesFromFile(link));
    }
}

