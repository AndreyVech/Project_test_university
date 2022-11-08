package org.example;

import static org.example.StudyProfile.*;

public class Main {
    public static void main(String[] args) {
        University university1 = new University("1",
                "Московский технический университет связи и информатики",
                "МТУСИ", 1988, history);
        University university2 = new University("2",
                "Московский государственный технологический университет Станкини",
                "МГТУС", 1987, medicine);
        Student student1 = new Student("Петров Сергей", "1", 3, (float) 4.33);

        System.out.println(university1.toString());
        System.out.println(university2.toString());
        System.out.println(student1.toString());

    }
}