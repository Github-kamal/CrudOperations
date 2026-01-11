package com.payilgam.CrudOperations.service;

import com.payilgam.CrudOperations.entity.EmpAcademics;
import com.payilgam.CrudOperations.entity.EmployeeEntity;
import com.payilgam.CrudOperations.entity.EmpAddressEntity;
import com.payilgam.CrudOperations.entity.UserEntity;
import com.payilgam.CrudOperations.pojo.AcademicsPojo;
import com.payilgam.CrudOperations.pojo.EmployeePojo;
import com.payilgam.CrudOperations.pojo.UserPojo;
import com.payilgam.CrudOperations.repo.AcedemicsRepo;
import com.payilgam.CrudOperations.repo.CrudRepo;
import com.payilgam.CrudOperations.repo.EmployeeAddressRepo;
import com.payilgam.CrudOperations.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrudService {

    @Autowired
    CrudRepo crudRepo;

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    EmployeeAddressRepo employeeAddressRepo;
    @Autowired
    AcedemicsRepo empAcademics;


    public String add(UserPojo pojo) {
        UserEntity entity = new UserEntity(pojo.getName(), pojo.getEmail(), pojo.getGender());
        crudRepo.save(entity);
        return "Success";
    }

    public String delete(String id) {
        crudRepo.deleteById(id);
        return "Deleted Successfully";
    }


    @Transactional
    public String updateuser(UserPojo pojo) {
        Optional<UserEntity> existingUser = crudRepo.findById(pojo.getId());

        if (existingUser.isEmpty()) {
            return "User not found";
        } else {
            int updated = crudRepo.updateUserDetails(pojo.getId(), pojo.getName(), pojo.getEmail(), pojo.getGender());
            return updated > 0 ? "Updated Successfully" : "No changes";
        }
    }

    public UserPojo find(String id) {
        UserEntity entity = crudRepo.findById(id).orElse(null);
        if (entity == null) return null;
        UserPojo pojo = new UserPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setEmail(entity.getEmail());
        pojo.setGender(entity.getGender());
        return pojo;
    }


    // Fixed: addEmployee now has a return type and uses EmployeeRepo to save EmployeeEntity
    public String addEmployee(@Valid EmployeePojo pojo) {
        // Persist address first (optional if CascadeType.ALL is set)
        EmpAddressEntity addressEntity = new EmpAddressEntity();
        addressEntity.setStreet(pojo.getAddress().getStreet());
        addressEntity.setCity(pojo.getAddress().getCity());
        addressEntity.setState(pojo.getAddress().getState());
        addressEntity.setZipcode(pojo.getAddress().getZipcode());
        employeeAddressRepo.save(addressEntity);

        // Now persist employee
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(pojo.getName());
        employeeEntity.setDepartment(pojo.getDepartment());
        employeeEntity.setSalary(pojo.getSalary());
        employeeEntity.setAddress(addressEntity);// Set the persisted address
        employeeRepo.save(employeeEntity);

        return "Employee Added Successfully";

    }

    public String addEmpAcademics(@Valid AcademicsPojo pojo) {
        EmpAcademics academics = new EmpAcademics();
        academics.setDegree(pojo.getDegree());
        academics.setUniversity(pojo.getUniversity());
        academics.setYearOfPassing(pojo.getYearOfPassing());
        // Fetch and set the associated EmployeeEntity
        Optional<EmployeeEntity> employeeOpt = employeeRepo.findById(Math.toIntExact(pojo.getEmployeeId()));
        if (employeeOpt.isPresent()) {
            academics.setEmployeeEntity(employeeOpt.get());
            academics.setPercentage(pojo.getPercentage());
            empAcademics.save(academics);
            return "Academics Added Successfully";
        } else {
            return "Employee not found";

        }


    }
}