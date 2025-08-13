package com.Studentdb.Studentdb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Admin {
    @Id
    private Long adminId;
    private String adminName;
    private String adminEmail;
    private String password;

    @ManyToOne
    private Department department;
}
