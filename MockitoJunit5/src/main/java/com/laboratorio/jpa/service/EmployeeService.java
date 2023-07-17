package com.laboratorio.jpa.service;

import java.util.List;
import java.util.Optional;

import com.laboratorio.jpa.beans.Employee;

public interface EmployeeService {

    Integer count();

    List<Employee> findAll();

    Employee findOne(Long id);

    Optional<Employee> findOneOptional(Long id);

    Employee save(Employee employee);

    boolean delete(Long id);

    void deleteAll();
}
