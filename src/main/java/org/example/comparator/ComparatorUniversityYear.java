package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.University;

public class ComparatorUniversityYear implements ComparatorUniversity {

    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o2.getYearOfFoundation(), o1.getYearOfFoundation());
    }
}
