package org.example.OOP.collections;

import java.util.ArrayList;
import java.util.List;

public class Schule {
    List<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }

    public void print(){
        for(Student student:students){
            System.out.println(student);
        }
    }

    public Student findStudent(int id){
        for(Student student:students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }

    public List<Kurs> getKurseForStudent(int id){
        return findStudent(id).getKurse();
    }

    public void removeStudent(Student student){
        students.remove(student);
    }
}
