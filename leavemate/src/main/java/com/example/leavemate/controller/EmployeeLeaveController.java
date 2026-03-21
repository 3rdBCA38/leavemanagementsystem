package com.example.leavemate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.leavemate.model.EmployeeLeave;
import com.example.leavemate.repository.EmployeeLeaveRepository;

@RestController
@RequestMapping("/leaves")
@CrossOrigin(origins ="*")

public class EmployeeLeaveController {

    @Autowired
    private EmployeeLeaveRepository repo;

    // ✅ READ
    @GetMapping
    public List<EmployeeLeave> getAllLeaves() {
        return repo.findAll();
    }

    // ✅ CREATE
    @PostMapping
    public EmployeeLeave addLeave(@RequestBody EmployeeLeave leave) {
        leave.setStatus("Pending");
        return repo.save(leave);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public EmployeeLeave updateLeave(@PathVariable Long id, @RequestBody EmployeeLeave leave) {
        leave.setId(id);
        return repo.save(leave);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Long id) {
        repo.deleteById(id);
    }
}