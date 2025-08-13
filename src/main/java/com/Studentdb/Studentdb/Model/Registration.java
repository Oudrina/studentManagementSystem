package com.Studentdb.Studentdb.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private  Long registrationId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private  Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private  Course course;

    private String grade;
    private LocalDateTime registeredAt;
}
