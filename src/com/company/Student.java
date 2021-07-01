package com.company;

import java.util.List;

public class Student {
    String name;
    List<Hobby> hobbies;

    public Student(String name, List<Hobby> hobbies){
    this.name = name;
    this.hobbies = hobbies;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
