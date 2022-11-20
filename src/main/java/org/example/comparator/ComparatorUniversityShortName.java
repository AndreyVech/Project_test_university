package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.University;

public class ComparatorUniversityShortName implements ComparatorUniversity {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o2.getShortName(), o1.getShortName());
    }
}
