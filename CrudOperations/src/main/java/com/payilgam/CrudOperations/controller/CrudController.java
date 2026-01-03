package com.payilgam.CrudOperations.controller;

import com.payilgam.CrudOperations.pojo.UserPojo;
import com.payilgam.CrudOperations.service.CrudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CrudController
{

    @Autowired
    CrudService crudService;


    @PostMapping("/adduser")
    public ResponseEntity<?> adduser(@Valid @RequestBody UserPojo pojo) {
        return ResponseEntity.ok(crudService.add(pojo));
    }

    @DeleteMapping("/removeuser")
    public ResponseEntity<?> removeuser(@RequestParam String id) {
        return ResponseEntity.ok(crudService.delete(id));
    }

    @PutMapping("/updateuser")
    public ResponseEntity<?> updateuser(@RequestBody UserPojo pojo) {
        return ResponseEntity.ok(crudService.updateuser(pojo));
    }

    @GetMapping("/finduser")
    public ResponseEntity<?> finduser(@RequestParam String id) {
        return ResponseEntity.ok(crudService.find(id));
    }

}
