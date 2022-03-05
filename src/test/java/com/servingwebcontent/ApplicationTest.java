package com.servingwebcontent;

import com.servingwebcontent.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@EnableJpaRepositories(basePackages = {"com.servingwebcontent"})
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAddressBook() throws Exception{
        this.mockMvc.perform(get("/addressbook/{id}", 1).
                contentType(MediaType.APPLICATION_FORM_URLENCODED)).
                andExpect(status().isOk()).
                andReturn();
    }

    @Test
    public void createBuddyInfo() throws Exception{
        this.mockMvc.perform(get("/addBuddy/{id}", 1)).
                andExpect(status().isOk()).
                andReturn();
    }

/*
    @Test
    public void addBuddyInfo() throws Exception{
        this.mockMvc.perform(post("/addBuddy/{id}", 1).
                param("name", "Nikki").
                param("phoneNum", "111112222").
                param("address", "151Road").
                contentType(MediaType.APPLICATION_FORM_URLENCODED)).
                andExpect(status().isOk()).
                andExpect(redirectedUrl("/addressbook/1"));
    }
   
 */
}
