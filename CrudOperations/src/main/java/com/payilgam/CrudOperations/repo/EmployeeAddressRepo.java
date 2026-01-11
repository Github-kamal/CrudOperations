package com.payilgam.CrudOperations.repo;


import com.payilgam.CrudOperations.entity.EmpAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAddressRepo extends JpaRepository<EmpAddressEntity, Integer> {
}
