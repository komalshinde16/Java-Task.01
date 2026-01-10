package com.itshaala.Service;

import com.itshaala.Model.StudentModel;
import com.itshaala.Service.StudentService;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<StudentModel> list = new ArrayList<>();

    public void addStudent(StudentModel s) {
        list.add(s);
    }

    public ArrayList<StudentModel> getAllStudents() {
        return list;
    }

    public StudentModel findById(int id) {
        for (StudentModel s : list)
            if (s.getId() == id)
                return s;
        return null;
    }

    public boolean deleteStudent(int id) {
        StudentModel s = findById(id);
        if (s != null) {
            list.remove(s);
            return true;
        }
        return false;
    }

}
