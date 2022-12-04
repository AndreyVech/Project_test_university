package org.example.comparatorIn;

import org.apache.commons.lang3.StringUtils;
import org.example.model.Student;

public class ComparatorStudentUniversityId implements ComparatorStudent {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o2.getUniversityId(), o1.getUniversityId());
    }
}
