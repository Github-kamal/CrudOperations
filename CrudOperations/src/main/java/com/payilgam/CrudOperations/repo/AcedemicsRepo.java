package com.payilgam.CrudOperations.repo;

import com.payilgam.CrudOperations.entity.EmpAcademics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcedemicsRepo extends JpaRepository<EmpAcademics, Integer> {

}
