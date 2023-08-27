package com.nagarro.azureAssignment1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.azureAssignment1.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findByLastName(String lastName);
    
}
