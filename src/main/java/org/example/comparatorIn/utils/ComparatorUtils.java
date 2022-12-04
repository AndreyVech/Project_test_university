package org.example.comparatorIn.utils;

import org.example.comparatorIn.*;
import org.example.enums.ComparatorTypeStudent;
import org.example.enums.ComparatorTypeUniversity;

public class ComparatorUtils {

        private ComparatorUtils() {
        }

        public static ComparatorStudent getStudentComparator(ComparatorTypeStudent comparatorTypeStudent) {

            switch (comparatorTypeStudent) {

                case UNIVERSITY_ID:
                    return new ComparatorStudentUniversityId();
                case COURSE:
                    return new ComparatorStudentCourse();
                case AVG_EXAM_SCORE:
                    return new ComparatorStudentAvgScore();
                default:
                    return new ComparatorStudentFullName();
            }
        }

        public static ComparatorUniversity getUniversityComparator(ComparatorTypeUniversity comparatorTypeUniversity) {

            switch (comparatorTypeUniversity) {

                case ID:
                    return new ComparatorUniversityId();
                case SHORT_NAME:
                    return new ComparatorUniversityShortName();
                case PROFILE:
                    return new ComparatorUniversityProfile();
                case YEAR:
                    return new ComparatorUniversityYear();
                default:
                    return new ComparatorUniversityFullName();
            }
        }
    }

