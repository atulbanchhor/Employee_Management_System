package com.emp.demo.Service;

import com.emp.demo.Entity.Employee;
import com.emp.demo.Repository.EmpRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    private EmpRepo repo;

    public void addEmp(Employee e) {
        repo.save(e);
    }

    // to show data what we feed into home page
    public List<Employee> getAllEmp() {
        return repo.findAll();
    }

    // after click edit there is ID must be fixed 55:45
    public Employee getEmptById(int id) {
        Optional<Employee> e = repo.findById(id);
        if (e.isPresent()) {
            return e.get();
        }
        return null;
    }

    public void deleteEMP(int id) {
        repo.deleteById(id);
    }
}
