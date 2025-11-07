package com.typebdigital.greetingservice.api;

import com.typebdigital.greetingservice.dto.GreetingMessageDto;
import com.typebdigital.greetingservice.exception.InvalidInputException;
import com.typebdigital.greetingservice.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(GreetingController.class)
public class GreetingControllerUT {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GreetingService greetingService;

    @Test
    void greetingSuccess_200_with_Valid_Name() throws Exception {

        when(greetingService.greet("Alice")).thenReturn(GreetingMessageDto.builder().message("Hello Alice").build());

        mockMvc.perform(get("/hello-world")
                        .param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Alice"));
    }

    @Test
    void greetingFailed_400_without_Present_Name_Parameter() throws Exception {

        mockMvc.perform(get("/hello-world"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void greetingFailed_400_with_Invalid_Name() throws Exception {

        when(greetingService.greet("")).thenThrow(new InvalidInputException("Invalid Input"));

        mockMvc.perform(get("/hello-world")
                        .param("name", ""))
                .andExpect(status().isBadRequest());
    }
}
