package org.example.sourse.xlsxWriteUtils;

import org.apache.commons.lang3.StringUtils;
import org.example.enums.StudyProfile;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class XlsxStatisticsUtil {
    private XlsxStatisticsUtil() {
    }

    ;

    public static List<Statistics> createStatList1(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());
        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(profile);
            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setUniversityCnt(profileUniversityIds.size());
            statistics.setUniversityNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityNames(
                            statistics.getUniversityNames() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setStudentsCnt(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.getAvgScore();
            avgExamScore.ifPresent(value -> statistics.setAvgScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });
        return statisticsList;
    }

    public static List<Statistics> createStatList2(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        universities.forEach(university -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setUniversityNames(university.getShortName());

            List<Student> studentCnt = students.stream()
                    .filter(student -> university.getId().contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setStudentsCnt(studentCnt.size());

        });
        return statisticsList;
    }
}
