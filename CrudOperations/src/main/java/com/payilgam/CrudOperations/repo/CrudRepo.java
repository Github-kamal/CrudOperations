package com.payilgam.CrudOperations.repo;

import com.payilgam.CrudOperations.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CrudRepo extends JpaRepository<UserEntity, String> {





    @Transactional
    @Modifying
    @Query(value = "UPDATE user_details SET name = :name, email = :email, gender = :gender WHERE id = :id", nativeQuery = true)
    int updateUserDetails(@Param("id") String id,
                          @Param("name") String name,
                          @Param("email") String email,
                          @Param("gender") String gender);


    Optional<UserEntity> findById(String id);
}


