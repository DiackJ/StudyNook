package com.api.StudyNookBackend.Controller;

import com.api.StudyNookBackend.DTO.UserClassDTO;
import com.api.StudyNookBackend.Entity.UserClass;
import com.api.StudyNookBackend.Service.UserClassService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//handles endpoint logic for classes
@RestController
@RequestMapping("/class")
public class UserClassController {
    @Autowired
    private UserClassService userClassService;

    @PostMapping("/create-class")
    public ResponseEntity<UserClass> createUserClass(@RequestBody UserClassDTO dto, HttpServletRequest req){
        UserClass userClass = userClassService.addNewClass(dto, req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userClass);
    }
}
