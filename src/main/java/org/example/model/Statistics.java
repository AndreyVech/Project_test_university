package org.example.model;

import org.example.enums.StudyProfile;

public class Statistics {
    private StudyProfile studyProfile;
    private float avgScore;
    private int studentsCnt;
    private int universityCnt;
    private String universityNames;

    public Statistics(){};

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public Statistics setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        return this;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public Statistics setAvgScore(float avgScore) {
        this.avgScore = avgScore;
        return this;
    }

    public int getStudentsCnt() {
        return studentsCnt;
    }

    public Statistics setStudentsCnt(int studentsCnt) {
        this.studentsCnt = studentsCnt;
        return this;
    }

    public int getUniversityCnt() {
        return universityCnt;
    }

    public Statistics setUniversityCnt(int universityCnt) {
        this.universityCnt = universityCnt;
        return this;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public Statistics setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
        return this;
    }
}
