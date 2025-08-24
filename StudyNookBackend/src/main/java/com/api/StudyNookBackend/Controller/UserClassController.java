package com.api.StudyNookBackend.Controller;

import com.api.StudyNookBackend.DTO.UserClassDTO;
import com.api.StudyNookBackend.Entity.UserClass;
import com.api.StudyNookBackend.Service.UserClassService;
import com.api.StudyNookBackend.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.StudyNookBackend.Entity.User;

//handles endpoint logic for classes
@RestController
public class UserClassController {
    @Autowired
    private UserClassService userClassService;
    @Autowired
    private UserService userService;

    @PostMapping("/classes")
    public ResponseEntity<UserClassDTO> createUserClass(@RequestBody UserClassDTO dto, HttpServletRequest req){
        if(dto.getName() == null || dto.getName().isEmpty()){
            throw new RuntimeException("please enter a name for your class");
        }
        // create a new user class entity and map the persisted data back to the dto to return instead of exposing
        // the raw entity
        UserClass userClass = userClassService.addNewClass(dto, req);
        dto.setUserId(userClass.getUser().getId());
        dto.setCreatedAt(userClass.getCreatedAt());
        dto.setUpdatedAt(userClass.getUpdatedAt());
        dto.setId(userClass.getId());
        dto.setIsActive(userClass.getIsActive());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dto);
    }
}
