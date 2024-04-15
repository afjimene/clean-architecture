package com.ecommerce.product.controller;

import com.ecommerce.product.api.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void addProductTestWithMockMvc(@Autowired MockMvc mvc) throws Exception {
        var product = new Product();
        product.setName("something");
        product.setStatusId(1);
        product.setStock(100L);
        product.setDescription("something");
        product.setPrice(1000.0);
        var servletContext = webApplicationContext.getServletContext();
        mvc.perform(MockMvcRequestBuilders
                        .post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("something"));
    }

    @Test
    void getProductByIdTestWithMockMvc(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/product/1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("tablet"));
    }

    @Test
    void updateProductTestWithMockMvc(@Autowired MockMvc mvc) throws Exception {
        var product = new Product();
        product.setId(4);
        product.setName("cellphone");
        product.setStatusId(1);
        product.setStock(30L);
        product.setDescription("A cellphone from Samsung");
        product.setPrice(2500.0);
        var servletContext = webApplicationContext.getServletContext();
        mvc.perform(MockMvcRequestBuilders
                        .put("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("2500.0"));
    }
}
