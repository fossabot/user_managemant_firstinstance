package com.Looyas.demo.unitTest.UserTest;

import com.Looyas.demo.models.User;
import com.Looyas.demo.services.UserService;
import com.Looyas.demo.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
public class UserServiceTest {
    private MockMvc mvc;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(userService).build();
    }


    @Test
    public void whenFindAll_thenReturnUsers(){

        User user = new User("gjlh", "opjù", "lkjmkj", "ioujiou", "uihuihoklj");
        List<User> users = new ArrayList<User>();
        users.add(user);
        userRepository.save(user);
        List<User> result = (List<User>) userService.findAll();
        assertEquals(users.get(0).getUserId(), result.get(0).getUserId());
    }




}