package org.example.comparatorIn;

import org.apache.commons.lang3.StringUtils;
import org.example.model.University;

public class ComparatorUniversityFullName implements ComparatorUniversity {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o2.getFullName(), o1.getFullName());
    }
}
