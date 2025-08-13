package com.Studentdb.Studentdb.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private String  departmentName;
    private String departmentCode;
}
