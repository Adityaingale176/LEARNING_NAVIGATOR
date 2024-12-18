package com.example.Learning_Navigator.Learning_Navigator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Learning_Navigator.Learning_Navigator.Entity.Students;

public interface StudentRepository extends JpaRepository<Students, Integer>{

}
