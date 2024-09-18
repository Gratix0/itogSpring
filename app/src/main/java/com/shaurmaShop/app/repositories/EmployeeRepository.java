package com.shaurmaShop.app.repositories;

import com.shaurmaShop.app.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}