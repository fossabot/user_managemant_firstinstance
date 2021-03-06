package com.Looyas.demo.unitTest.UserTest;

import com.Looyas.demo.constants.Paths;
import com.Looyas.demo.controllers.UserController;
import com.Looyas.demo.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class UserControllerTest {

    private MockMvc mvc;


    @Mock
    private UserController userController;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    ///getUsers test
    @Test
    public void whenGetAllUsers_thenReturnUsers() throws Exception {
        List<User> users = new ArrayList<User>();
        User user = new User("gjlh", "opjù", "lkjmkj", "ioujiou", "uihuihoklj");
        users.add(user);
        when(userController.getAllUsers()).thenReturn(users);
        mvc.perform(MockMvcRequestBuilders.get(Paths.GETUSER))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)));
        ;
        Mockito.verify(userController).getAllUsers();
    }

    ///getUserById test
    @Test
    public void whenFindUserById_thenReturnUser() throws Exception {
        User user = new User("ajkhuimert1245", "gjlh", "opjù", "lkjmkj", "ioujiou", "uihuihoklj");

        when(userController.getUserByID("ajkhuimert1245")).thenReturn(java.util.Optional.of(user));
        mvc.perform(get(Paths.GETUSERBYID + "/" + "ajkhuimert1245"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.userId", is("ajkhuimert1245")));
        Mockito.verify(userController).getUserByID("ajkhuimert1245");
    }

    ///addUser test
    @Test
    public void whenAddUser_thenReturnUser() throws Exception {

        User user = new User( "opjù", "opjù", "ioujiou", "ioujiou","noumhhhdhhiiiihi@looyas.com");
        when(userController.addUser(user)).thenReturn(user);
        User result = userController.addUser(user);
        Assert.assertEquals(user,result);
        Mockito.verify(userController).addUser(user);
    }
}