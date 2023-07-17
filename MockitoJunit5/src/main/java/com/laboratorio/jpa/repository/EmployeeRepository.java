package com.laboratorio.jpa.repository;

import java.util.List;

import com.laboratorio.jpa.beans.Employee;

public interface EmployeeRepository {

    Integer count();

    List<Employee> findAll();

    Employee findOne(Long id);
    
    Employee save(Employee smartphone);

    boolean delete(Long id);

    void deleteAll();

}
