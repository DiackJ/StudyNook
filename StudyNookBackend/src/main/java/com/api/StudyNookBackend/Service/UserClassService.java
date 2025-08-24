package com.api.StudyNookBackend.Service;

import com.api.StudyNookBackend.DTO.UserClassDTO;
import com.api.StudyNookBackend.Entity.User;
import com.api.StudyNookBackend.Entity.UserClass;
import com.api.StudyNookBackend.Repository.UserClassRepository;
import com.api.StudyNookBackend.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//handles all the functionality for the classes
@Service
public class UserClassService {
    @Autowired
    private UserClassRepository userClassRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public UserClassService(){}

    public UserClass addNewClass(UserClassDTO dto, HttpServletRequest req){
        UserClass userClass = new UserClass();
        User user = userService.getUser(req);
        userClass.setName(dto.getName());
        userClass.setUser(user);
        userClass.setIsActive(true);

        return userClassRepository.save(userClass);
    }

//    public List<UserClass> getUserClasses(HttpServletRequest req){
//
//    }
}
