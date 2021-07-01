package com.company;

import java.util.*;

public class Main {
    static Map<Student, List<Hobby>> studentHobby= new HashMap<>();

    public static void main(String[] args) {



        List<Hobby> hobbyListOfStudentOne= new ArrayList<>();

        List<Hobby> hobbyListOfStudentTwo= new ArrayList<>();

        List<Hobby> hobbyListOfStudentTree = new ArrayList<>();


        List<String>bikingAddresses = new ArrayList<String>();
        bikingAddresses.add("Busteni");
        bikingAddresses.add("Lopatari");
        bikingAddresses.add("Bucegi");

        List<String>skatingAddresses = new ArrayList<>();
        skatingAddresses.add("Bucuresti");
        skatingAddresses.add("Buzau");

        List<String>readingAddresses = new ArrayList<>();
        readingAddresses.add("Home");
        readingAddresses.add("Library");
        readingAddresses.add("Park");


        Hobby hobby1 = new Hobby("biking",2,bikingAddresses);

        Hobby hobby2 = new Hobby("skating",4,skatingAddresses);

        Hobby hobby3 = new Hobby("reading",2,readingAddresses);

        hobbyListOfStudentOne.add(hobby1);
        hobbyListOfStudentOne.add(hobby2);

        hobbyListOfStudentTwo.add(hobby2);

        hobbyListOfStudentTree.add(hobby3);
        hobbyListOfStudentTree.add(hobby1);

        Student studentOne = new Student("Gheorghe",hobbyListOfStudentOne);
        Student studentTwo = new Student("Vasile",hobbyListOfStudentTwo);
        Student studentTree = new Student("Mihai",hobbyListOfStudentTree);


        showStudentHobbies(studentOne);
        showStudentHobbies(studentTwo);
        showStudentHobbies(studentTree);


        Collection<Student> studentWithSimilarHobbies1 = findStudentWithHobby(hobby1,studentHobby);
        Collection<Student> studentWithSimilarHobbies2 = findStudentWithHobby(hobby2,studentHobby);
        Collection<Student> studentWithSimilarHobbies3 = findStudentWithHobby(hobby3,studentHobby);

        showStudentsWithSimilarHobbies(studentWithSimilarHobbies1);
        System.out.println(" ");
        showStudentsWithSimilarHobbies(studentWithSimilarHobbies2);
        System.out.println(" ");
        showStudentsWithSimilarHobbies(studentWithSimilarHobbies3);

        System.out.println(" ");

        Collection<Student> studentWithIntersectedHobbies = findIntersection(studentWithSimilarHobbies1,studentWithSimilarHobbies2);

        showStudentsWithIntersectedHobbies(studentWithIntersectedHobbies);


    }

    public static void addToHashMap(Student student){
            studentHobby.put(student,student.hobbies);
    }

    public static void showStudentHobbies(Student student) {
        addToHashMap(student);
        for(Student key: studentHobby.keySet()){
            if(key.getName().equals(student.name)){
                System.out.println("lista de hobby uri pentru: " + key.getName());
                for (Hobby s: studentHobby.get(key)){
                    System.out.println( s.getNameOfHobby()+ " "+ s.getAddresses() );
                }
            }
        }
    }

    public static  Collection<Student> findStudentWithHobby (Hobby hobby, Map<Student,List<Hobby>> studentHobby ){
        Collection<Student> studentsWithSimilarHobbies = new ArrayList<>();
             for(Map.Entry<Student, List<Hobby>> h: studentHobby.entrySet() ) {
                 for(int i=0;i<h.getValue().size();i++){
                if (h.getValue().get(i).equals(hobby)) {
                 studentsWithSimilarHobbies.add(h.getKey());
            }
                 }
        }
        return studentsWithSimilarHobbies;
    }

    public static void showStudentsWithSimilarHobbies(Collection<Student> studentCollection){
        System.out.print("studentii cu acest hobby sunt: ");
        for (Student s: studentCollection) {
            System.out.print(s.getName() + " ");
        }
    }

    public static void showStudentsWithIntersectedHobbies(Collection<Student> studentCollection){
        System.out.print("studentii cu hobbyi-uri intersectate sunt: ");
        for (Student s: studentCollection) {
            System.out.print(s.getName() + " ");
        }
    }

    public static Collection<Student> findIntersection(Collection<Student> c1,Collection<Student> c2){
        Collection<Student> intersectedStudents = new ArrayList<>();
        for (Student c: c1){
            for (Student d: c2){
                if (c.equals(d)){
                    intersectedStudents.add(c);
                }
            }
        }
        return intersectedStudents;
    }


}
