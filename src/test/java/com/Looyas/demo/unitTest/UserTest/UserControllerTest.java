package com.looyas.demo.unitTest.UserTest;
import com.looyas.demo.controllers.UserController;
import com.looyas.demo.models.User;
import com.looyas.demo.repositories.RoleRepository;
import com.looyas.demo.repositories.UserRepository;
import com.looyas.demo.security.jwt.JwtProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
//@RunWith(SpringRunner.class) //is used to provide a bridge between Spring Boot test features and JUnit
//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
//    @Autowired
//    protected WebApplicationContext wac;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtProvider jwtProvider;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private  UserController userController;
    @Test
    public void whenfindALL_thenReturnUSERS ()  {
        User user = new User("gjlh","opjù","lkjmkj","ioujiou","uihuihoklj");
        userRepository.save(user);
        List<User> users = new ArrayList<User>();
        users.add(user);
        when(userController.findAllUser()).thenReturn((ResponseEntity<Iterable<User>>) users);
        Assert.assertEquals("users", users);
    }

}