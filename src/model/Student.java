package model;

import java.util.Date;

public class Student {
    private String name;
    private String studentCode;
    private String dateOfBirth;
    private String class1;

    public Student() {
    }

    public Student(String name, String studentCode, String dateOfBirth, String class1) {
        this.name = name;
        this.studentCode = studentCode;
        this.dateOfBirth = dateOfBirth;
        this.class1 = class1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return "name= " + name +
                ", studentCode= " + studentCode +
                ", dateOfBirth= " + dateOfBirth +
                ", class1= " + class1
               ;
    }
}
