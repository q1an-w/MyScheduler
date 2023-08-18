package com.wang.webservice.mongodb.model.Course;

import com.wang.webservice.mongodb.model.Course.Grades.*;
import org.bson.types.ObjectId;
import org.springframework.validation.ObjectError;

public class Course {
    private ObjectId courseID;
    private String courseCode;
    private String lab;
    private String courseOutline;
    private String courseName;
    private GradingScheme gradingScheme;
    private Grades grades;
    private float courseGrade;
    private float courseFinalGrade;

    public Course(){
        this.courseID = new ObjectId();
        this.courseCode = "";
        this.lab = "";
        this.courseOutline = "";
        this.courseName = "";
        this.gradingScheme = new GradingScheme();
        this.grades = new Grades();
        this.courseGrade = 0;
        this.courseFinalGrade = 0;
    }

    public Course(String courseCode, String lab, String courseOutline, String courseName, GradingScheme gradingScheme, Grades grades, float courseGrade, float courseFinalGrade) {
        this.courseID = new ObjectId();
        this.courseCode = courseCode;
        this.lab = lab;
        this.courseOutline = courseOutline;
        this.courseName = courseName;
        this.gradingScheme = gradingScheme;
        this.grades = grades;
        this.courseGrade = courseGrade;
        this.courseFinalGrade = courseFinalGrade;
    }

    public ObjectId getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = new ObjectId(courseID);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getCourseOutline() {
        return courseOutline;
    }

    public void setCourseOutline(String courseOutline) {
        this.courseOutline = courseOutline;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public GradingScheme getGradingScheme() {
        return gradingScheme;
    }

    public void setGradingScheme(GradingScheme gradingScheme) {
        this.gradingScheme = gradingScheme;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public float getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(float courseGrade) {
        this.courseGrade = courseGrade;
    }

    public float getCourseFinalGrade() {
        return courseFinalGrade;
    }

    public void setCourseFinalGrade(float courseFinalGrade) {
        this.courseFinalGrade = courseFinalGrade;
    }
}
