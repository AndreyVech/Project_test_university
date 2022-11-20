package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.University;

public class ComparatorUniversityProfile implements ComparatorUniversity {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o2.getMainProfile().name(), o1.getMainProfile().name());
    }
}
