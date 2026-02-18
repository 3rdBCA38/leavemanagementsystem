package com.example.leavemate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.leavemate.model.EmployeeLeave;
import com.example.leavemate.repository.EmployeeLeaveRepository;

@RestController
@CrossOrigin(origins = "https://leavemanagementsystem-sigma.vercel.app")
@RequestMapping("/leaves")


public class EmployeeLeaveController {

    @Autowired
    private EmployeeLeaveRepository repo;

    // CREATE
    @PostMapping
    public EmployeeLeave addLeave(@RequestBody EmployeeLeave leave) {
        leave.setStatus("Pending");
        return repo.save(leave);
    }

    // READ
    @GetMapping
    public List<EmployeeLeave> getAllLeaves() {
        return repo.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public EmployeeLeave updateLeave(@PathVariable Long id, @RequestBody EmployeeLeave leave) {
        leave.setId(id);
        return repo.save(leave);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
