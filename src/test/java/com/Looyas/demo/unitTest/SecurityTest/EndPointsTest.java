package com.Looyas.demo.unitTest.SecurityTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EndPointsTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(this.wac).build();
    }

    @Test
    public void auth_isAvailableToEveryone() throws Exception {

         mvc.perform(get("http://192.168.10.193:8008/auth/").contentType(APPLICATION_JSON));
    }





}
