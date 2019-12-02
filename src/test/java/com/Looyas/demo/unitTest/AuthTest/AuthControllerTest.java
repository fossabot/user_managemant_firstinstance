//package com.looyas.demo.unitTest.AuthTest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.looyas.demo.controllers.AuthController;
//import com.looyas.demo.messages.requests.LoginForm;
//import com.looyas.demo.messages.requests.SignUpForm;
//import com.looyas.demo.messages.responses.JwtResponse;
//import com.looyas.demo.repositories.UserRepository;
//import com.looyas.demo.security.jwt.JwtProvider;
//import com.looyas.demo.services.impl.UserPrinciple;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.test.context.support.WithAnonymousUser;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import sun.awt.windows.WPrinterJob;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
//import static org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder.webAppContextSetup;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class AuthControllerTest {
//    @Autowired
//
//WebApplicationContext applicationContext;
//    private MockMvc mvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Mock
//    private AuthController authController;
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JwtProvider jwtProvider;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders.standaloneSetup(authController).build();
////        LoginForm loginForm = new LoginForm();
////        loginForm.setPassword("almzekj");
////        loginForm.setUsername("dlsghi");
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(
////                        "almzekj",
////                        "dlsghi"
////                )
////        );
//      //  mvc = webAppContextSetup( applicationContext).apply(springSecurity()).build();
//
//    // SecurityContextHolder.getContext().setAuthentication(authentication);
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        UserPrinciple user = new UserPrinciple("","","","","","",authorities);
//        user.setUsername("dlsghi");
//        user.setPassword("almzekj");
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, "almzekj");
//        SecurityContextHolder.getContext().setAuthentication(token);
//    }
//
//
////    @Test
////    public void authenticateUserTest() throws Exception {
////
////        LoginForm loginForm = new LoginForm();
////        loginForm.setPassword("almzekj");
////        loginForm.setUsername("dlsghi");
////
////
////        Set<String> strRoles = new HashSet<>();
////        strRoles.add("admin");
////
////        SignUpForm signUpForm = new SignUpForm();
////        signUpForm.setUserName("dlsghi");
////        signUpForm.setFirstName("opjù");
////        signUpForm.setLastName("lkjmkj");
////        signUpForm.setPassword("almzekj");
////        signUpForm.setEmail("uihuihoklj");
////        signUpForm.setRole(strRoles);
//
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(
////                        loginForm.getUsername(),
////                       loginForm.getPassword()
////                )
////        );
//        //mvc.perform(post("/auth/signin").with(user("dlsghi").roles("ADMIN"))).andExpect(header().exists("Authorization"));
////     SecurityContextHolder.getContext().setAuthentication(authentication);
////
////       String jwt = jwtProvider.generateJwtToken(authentication);
////        JwtResponse jwtResponse = new JwtResponse(jwt);
////       mvc.perform(post("/auth/signup")
////                    .content(objectMapper.writeValueAsString(signUpForm))
////                    .contentType(MediaType.APPLICATION_JSON));
////            //        .andExpect(status().isOk());
////      when(authController.authenticateUser(loginForm)).thenReturn(jwt);
////
////        mvc.perform(post("/auth/signin")
////                    .content(objectMapper.writeValueAsString(loginForm))
////                    .contentType(MediaType.APPLICATION_JSON))
////                    .andExpect(status().isOk())
////                    .andExpect(header().exists("Authorization"));
////        }
//
//    @Test
//    @WithAnonymousUser
//    public  void  testAnonymous () throws Exception {
//        Authentication  auth  =  SecurityContextHolder . getContext (). getAuthentication ();
//      mvc.perform(post("/auth/signin")
//              .contentType(MediaType.APPLICATION_JSON))
//              .andExpect(status().isUnauthorized());
//    }
//
//
//    }
//
//
//
