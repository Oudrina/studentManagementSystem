package com.Studentdb.Studentdb.Repository;

import com.Studentdb.Studentdb.Model.Registration;
import com.Studentdb.Studentdb.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    List<Registration> findByStudent(Student student);

}
