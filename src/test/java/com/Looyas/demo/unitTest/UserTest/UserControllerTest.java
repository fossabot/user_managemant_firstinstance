package com.looyas.demo.unitTest.UserTest;
import com.looyas.demo.controllers.UserController;
import com.looyas.demo.models.User;
import com.looyas.demo.repositories.UserRepository;
import com.looyas.demo.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static com.looyas.demo.constants.Paths.USER;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class UserControllerTest {
    private MockMvc mvc;
    @Autowired
    private UserRepository userRepository;
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;
    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    public void whenfindALL_thenReturnUSERS() throws Exception {
        List<User> users = new ArrayList<User>();
        User user = new User("gjlh", "opjù", "lkjmkj", "ioujiou", "uihuihoklj");
        users.add(user);
        when(userService.findAll()).thenReturn(users);
        mvc.perform(get(USER))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(userService).findAll();
    }
}