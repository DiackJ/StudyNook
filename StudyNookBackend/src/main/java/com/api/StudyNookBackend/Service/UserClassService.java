package com.api.StudyNookBackend.Service;

import com.api.StudyNookBackend.DTO.UserClassDTO;
import com.api.StudyNookBackend.Entity.UserClass;
import com.api.StudyNookBackend.Repository.UserClassRepository;
import com.api.StudyNookBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public UserClass addNewClass(UserClassDTO dto){
        UserClass userClass = new UserClass();
        userClass.setName(dto.getName());

        return userClassRepository.save(userClass);
    }
}
