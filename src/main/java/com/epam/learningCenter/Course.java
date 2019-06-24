package com.epam.learningCenter;

public class Course {
    public Course(String name, int hourAmount) {
        this.name = name;
        this.hourAmount = hourAmount;
    }

    private String name;
    private int hourAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHourAmount() {
        return hourAmount;
    }

    public void setHourAmount(int hourAmount) {
        this.hourAmount = hourAmount;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name = '" + name + '\'' +
                ", hours = " + hourAmount +
                '}';
    }
}
