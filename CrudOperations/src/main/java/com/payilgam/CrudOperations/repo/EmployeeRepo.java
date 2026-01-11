package com.payilgam.CrudOperations.repo;

import com.payilgam.CrudOperations.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {
}

