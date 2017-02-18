package com.memefilter.controller.impl;

import com.memefilter.Application;
import com.memefilter.controller.AbstractControllerTest;
import com.memefilter.model.RealMeaning;
import com.memefilter.model.MemeText;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by aross on 18/02/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class FilterApiControllerTest extends AbstractControllerTest {

    private static final String BASE_URI = "/filter";
    private static final String IMAGE_PATH = "/memeText";
    private static final String TEXT_PATH = "/text";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Ignore
    @Test
    public void filterImagePost() {

    }

    @Test
    public void filterTextPost() throws Exception {
        MemeText input = new MemeText().memeText("Meme");

        RealMeaning output = new RealMeaning().memeText(input.getMemeText()).reality(input.getMemeText());


        MvcResult mvcResult = this.mockMvc.perform(post(BASE_URI + TEXT_PATH)
                .content(json(input))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(request().asyncStarted())
                .andReturn();

        mvcResult.getAsyncResult();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(json(output)))
                .andReturn();

    }

}