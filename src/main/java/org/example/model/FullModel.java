package org.example.model;

import jakarta.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;


@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class FullModel {

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> studentList;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universityList;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statisticsList;

    @XmlElement(name = "processedAt")
    private Date date;

    public FullModel() {
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public FullModel setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public FullModel setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public FullModel setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public FullModel setDate(Date date) {
        this.date = date;
        return this;
    }
}
