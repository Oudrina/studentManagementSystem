package com.Studentdb.Studentdb.Service;

import com.Studentdb.Studentdb.Model.Admin;
import com.Studentdb.Studentdb.Repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public  Admin  saveAdmin(Admin admin){
         return   adminRepository.save(admin);

    };

}
