package com.Studentdb.Studentdb.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long courseId;

    private String  courseName;
    private String  courseCode;

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Registration> registrations = new ArrayList<>();
}
