package org.example.comparator;

import org.example.model.Student;

public class ComparatorStudentAvgScore implements ComparatorStudent {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
