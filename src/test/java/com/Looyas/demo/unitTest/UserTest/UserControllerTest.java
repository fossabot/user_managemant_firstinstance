package com.Looyas.demo.unitTest.UserTest;

import com.Looyas.demo.controllers.AuthController;
import com.Looyas.demo.controllers.UserController;
import com.Looyas.demo.messages.requests.SignUpForm;
import com.Looyas.demo.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.util.List;

import static com.Looyas.demo.constants.Paths.VERSION;
import static java.util.Collections.singletonList;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc            mvc;

    @MockBean
    private AuthController authContrller;
    @MockBean
    SignUpForm signUpRequest;
    @Test
    public void addUserTest() throws Exception {
        signUpRequest user = new SignUpForm();
        signUpRequest.setEmail("nour.mhamdi@looyas.com");
        signUpRequest.setUserName("myusername");
        signUpRequest.setEmail("hhhhh");

        given(authContrller.registerUser(signUpRequest)).willReturn(() );
        URI auth;
        mvc.perform(get(auth  )                // .with(employee("blaze").password("Q1w2e3r4"))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].userId", is(user.getUserId())));
    }

}
