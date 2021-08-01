package com.test.user.service;

import com.test.user.entity.User;
import com.test.user.repository.UserRepo;
import com.test.user.vo.Department;
import com.test.user.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RestTemplate restTemplate;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public ResponseVO getUserwithDepartment(Long userId) {
        ResponseVO vo = new ResponseVO();
        User user = userRepo.getByUserId(userId);
        // Service Registry is resolving Department application as UNKNOWN hence put this name. need to fix this issue.
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+ user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
