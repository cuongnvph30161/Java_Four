package com.example.day4.model;

public class Student {
    String name;
    Double mark;
    // getters & setters

    public Student() {
    }

    public Student(String name, Double mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
