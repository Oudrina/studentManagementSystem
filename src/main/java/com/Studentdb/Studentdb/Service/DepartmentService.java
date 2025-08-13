package com.Studentdb.Studentdb.Service;

import com.Studentdb.Studentdb.Model.Course;
import com.Studentdb.Studentdb.Model.Department;
import com.Studentdb.Studentdb.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> allCourses(){
        return departmentRepository.findAll();
    }

    public Department saveCourse(Department department){
        return  departmentRepository.save(department);
    }
}
