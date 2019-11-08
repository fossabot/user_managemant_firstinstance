//package com.Looyas.demo.unitTest.UserTest;
//
//import com.Looyas.demo.controllers.UserController;
//import com.Looyas.demo.models.User;
//import com.Looyas.demo.repositories.UserRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import static com.Looyas.demo.constants.Paths.USER;
//
//import static java.util.Collections.singletonList;
//import static junit.framework.TestCase.assertTrue;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
////@RunWith(SpringRunner.class) //is used to provide a bridge between Spring Boot test features and JUnit
//@WebMvcTest(UserController.class)
//@AutoConfigureMockMvc
//public class UserControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private UserController userController;
//
//    UserRepository userRepository;
//    @Test
//    public void getAllUsersTest() throws Exception {
//
//        User user = new User();
//        user.setUserId("xxx");
//        user.setEmail("nour.mhamdi@looyas.com");
//        user.setUsername("myusername");
//        user.setPassword("hhhhh");
//        List<User> allUsers = new ArrayList<User>();
//        allUsers.add(user);
//        //given(userController.findAllUser()).willReturn((ResponseEntity<Iterable<User>>) allUsers);
//        mvc.perform(get(USER)                // .with(employee("blaze").password("Q1w2e3r4"))
//                .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].userId", is(user.getUserId())));
//    }
//
//
//
//
//}
