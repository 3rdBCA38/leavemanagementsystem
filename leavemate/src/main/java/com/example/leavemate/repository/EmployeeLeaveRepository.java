package com.example.leavemate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.leavemate.model.EmployeeLeave;

public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {
}
