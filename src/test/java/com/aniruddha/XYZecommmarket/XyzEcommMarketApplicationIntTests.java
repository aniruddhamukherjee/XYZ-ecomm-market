package com.aniruddha.XYZecommmarket;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;


public class XyzEcommMarketApplicationIntTests extends XyzEcommMarketApplicationUnitTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetProductBySkuApi() throws Exception {
        mockMvc.perform(get("/products/2")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.name", is("Nike Cap-1")))
                .andExpect(jsonPath("$.brand", is("Nike")))
                .andExpect(jsonPath("$.type", is("Cap")))
                .andExpect(jsonPath("$.supplier", is("AniruddhaRetail")))
                .andExpect(jsonPath("$.price", is(200.25)))
                .andExpect(jsonPath("$.size", is(36)))
                .andExpect(jsonPath("$.color", is("Yellow")));
    }

    @Ignore
    @Test
    public void testGetProductsByBrandApi(){
        //TODO similar logic as above
    }

    //TODO other similar integration tests of the exposed apis
}
