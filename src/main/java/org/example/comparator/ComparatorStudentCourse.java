package org.example.comparator;

import org.example.model.Student;

public class ComparatorStudentCourse implements ComparatorStudent {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o2.getCurrentCourseNumber(), o1.getCurrentCourseNumber());
    }
}
