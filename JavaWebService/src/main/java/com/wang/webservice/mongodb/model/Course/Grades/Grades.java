package com.wang.webservice.mongodb.model.Course.Grades;

public class Grades {
    private float finalExam;
    private float midtermExam;
    private float quiz;
    private float lab;
    private float assignments;
    private float misc;
    public Grades(){
        this.finalExam = 0;
        this.midtermExam = 0;
        this.quiz = 0;
        this.lab = 0;
        this.assignments = 0;
        this.misc = 0;

    }

    public Grades(float finalExam, float midtermExam, float quiz, float lab, float assignments, float misc) {
        this.finalExam = finalExam;
        this.midtermExam = midtermExam;
        this.quiz = quiz;
        this.lab = lab;
        this.assignments = assignments;
        this.misc = misc;
    }

    public float getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(float finalExam) {
        this.finalExam = finalExam;
    }

    public float getMidtermExam() {
        return midtermExam;
    }

    public void setMidtermExam(float midtermExam) {
        this.midtermExam = midtermExam;
    }

    public float getQuiz() {
        return quiz;
    }

    public void setQuiz(float quiz) {
        this.quiz = quiz;
    }

    public float getLab() {
        return lab;
    }

    public void setLab(float lab) {
        this.lab = lab;
    }

    public float getAssignments() {
        return assignments;
    }

    public void setAssignments(float assignments) {
        this.assignments = assignments;
    }

    public float getMisc() {
        return misc;
    }

    public void setMisc(float misc) {
        this.misc = misc;
    }

}
