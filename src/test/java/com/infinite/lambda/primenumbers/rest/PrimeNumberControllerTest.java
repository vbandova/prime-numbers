package com.infinite.lambda.primenumbers.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PrimeNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPrimeNumberCheck() throws Exception {

        mockMvc.perform(
                post("/api/vi/primes/check")
                        .param("number", "12")
        ).andExpect(status().isOk())
                .andExpect(content().string("false"));

    }

    @Test
    void testPrimeNumberCheckWithMissingParameter() throws Exception {

        mockMvc.perform(
                post("/api/vi/primes/check")
        ).andExpect(status().isBadRequest());

    }

    @Test
    void testPrimeNumberCheckWithWrongStringArgument() throws Exception {

        mockMvc.perform(
                post("/api/vi/primes/check")
                        .param("number", "Some text")
        ).andExpect(status().isBadRequest());

    }

    @Test
    void testPrimeNumberCheckWithWrongFloatingNumberArg() throws Exception {

        mockMvc.perform(
                post("/api/vi/primes/check")
                        .param("number", "15.6")
        ).andExpect(status().isBadRequest());

    }

    @Test
    void testNextPrimeNumber() throws Exception {

        mockMvc.perform(
                get("/api/vi/primes/next")
                        .param("number", "15")
        ).andExpect(status().isOk())
                .andExpect(content().string("17"));
    }

    @Test
    void testNextPrimeNumberWithMissingParameter() throws Exception {

        mockMvc.perform(
                get("/api/vi/primes/next")
        ).andExpect(status().isBadRequest());
    }

    @Test
    void testNextPrimeNumberWithWrongStringParameter() throws Exception {

        mockMvc.perform(
                get("/api/vi/primes/next")
                        .param("number", "Some text")
        ).andExpect(status().isBadRequest());
    }

    @Test
    void testNextPrimeNumberWrongFloatingNumberArg() throws Exception {

        mockMvc.perform(
                get("/api/vi/primes/next")
                        .param("number", "12.668")
        ).andExpect(status().isBadRequest());
    }

}