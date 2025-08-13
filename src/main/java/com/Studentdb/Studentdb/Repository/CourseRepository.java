package com.Studentdb.Studentdb.Repository;

import com.Studentdb.Studentdb.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
