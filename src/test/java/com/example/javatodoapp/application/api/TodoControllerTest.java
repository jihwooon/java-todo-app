package com.example.javatodoapp.application.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
class TodoControllerTest {


    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext context, RestDocumentationContextProvider contextProvider) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(contextProvider))
                .build();
    }

    @Test
    public void getTodos() throws Exception {
        mockMvc.perform(get("/todods")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
