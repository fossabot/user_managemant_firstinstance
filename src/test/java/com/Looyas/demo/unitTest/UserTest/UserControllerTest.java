package com.looyas.demo.unitTest.UserTest;

import com.looyas.demo.controllers.UserController;
import com.looyas.demo.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.looyas.demo.constants.Paths.GETUSER;
import static com.looyas.demo.constants.Paths.GETUSERBYID;
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
    public void whenFindALLUsers_thenReturnUsers() throws Exception {
        List<User> users = new ArrayList<User>();
        User user = new User("gjlh", "opjù", "lkjmkj", "ioujiou", "uihuihoklj");
        users.add(user);
        when(userController.findAllUser()).thenReturn(users);
        mvc.perform(get(GETUSER))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(userController).findAllUser();
    }

    ///getUserById test
    @Test
    public void whenFindUserById_thenReturnUser() throws Exception {
        User user = new User("ajkhuimert1245", "gjlh", "opjù", "lkjmkj", "ioujiou", "uihuihoklj");

        when(userController.findById("ajkhuimert1245")).thenReturn(java.util.Optional.of(user));
        mvc.perform(get(GETUSERBYID + "/" + "ajkhuimert1245"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.userId", is("ajkhuimert1245")));
        Mockito.verify(userController).findById("ajkhuimert1245");
    }

}