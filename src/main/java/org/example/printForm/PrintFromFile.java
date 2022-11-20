package org.example.printForm;

import static org.example.sourse.FileUtils.*;

public class PrintFromFile {
    public PrintFromFile(){}

    public static PrintFromFile printFromFileStudent(String link) {
        printStudents(loadStudentsFromFile(link));
        return null;
    };

    public static PrintDefault printFromFileUniversity(String link) {
        printUniver(loadUniversitiesFromFile(link));
        return null;
    }
}

