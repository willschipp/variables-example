package com.example.telco;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class EndpointTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mvc;

    @Value("${endpoint.value}")
    String envValue;

    @Before
    public void before() throws Exception {
        mvc = webAppContextSetup(context).build();
    }

    @Test
    public void testSuccessfulReplyWithEnvVariable() throws Exception {
        mvc.perform(get("/endpoint")).andExpect(status().isOk()).andExpect(content().string(envValue));
    }
}
