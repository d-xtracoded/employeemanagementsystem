package com.dxtracoded.EmployeeInformationSystem.repository;

import com.dxtracoded.EmployeeInformationSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
