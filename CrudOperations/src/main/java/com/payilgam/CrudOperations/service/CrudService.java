package com.payilgam.CrudOperations.service;

import com.payilgam.CrudOperations.entity.UserEntity;
import com.payilgam.CrudOperations.pojo.UserPojo;
import com.payilgam.CrudOperations.repo.CrudRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrudService {

    @Autowired
    CrudRepo crudRepo;
    public String add(UserPojo pojo)

        {
            UserEntity entity = new UserEntity(pojo.getName(), pojo.getEmail(), pojo.getGender());
            // Here you would typically save the entity to the database using a repository
            if(crudRepo.save(entity)!=null)
            {
                return "Success";
            }
                 return "Failure";
           }
    public String delete(String id)
    {
       crudRepo.deleteById(id);
        return "Deleted Successfully";
    }


    @Transactional
    public String updateuser(UserPojo pojo) {
        Optional<UserEntity> existingUser = crudRepo.findById(pojo.getId());

        if (existingUser.isEmpty()) {
            return "User not found";
        } else {
            crudRepo.updateUserDetails(pojo.getId(), pojo.getName(), pojo.getEmail(), pojo.getGender());
            return "Updated Successfully";
        }
    }

    public UserPojo find(String id)
    {
        UserEntity entity=crudRepo.findById(id).orElse(null);
        UserPojo pojo=new UserPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setEmail(entity.getEmail());
        pojo.setGender(entity.getGender());
        return pojo;
    }


}
