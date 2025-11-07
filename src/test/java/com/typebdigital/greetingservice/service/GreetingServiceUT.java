package com.typebdigital.greetingservice.service;

import com.typebdigital.greetingservice.dto.GreetingMessageDto;
import com.typebdigital.greetingservice.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GreetingServiceUT {

    private static GreetingService greetingService;

    @BeforeAll
    static void init() {
        greetingService = new GreetingService();
    }

    @Test
    void testGreeting_Success() {
        String name = "Alice";
        String expected = "Hello Alice";
        GreetingMessageDto expectedMessage = GreetingMessageDto.builder().message(name).build();

        GreetingMessageDto receivedMsg = greetingService.greet(name);

        assertNotNull(receivedMsg);
        assertEquals(expected, receivedMsg.getMessage());
    }

    @Test
    void testGreeting_Success_with_First_Letter_is_Simple() {
        String nameProvided = "alice";
        String expectedMsg = "Hello Alice";

        GreetingMessageDto receivedMsg = greetingService.greet(nameProvided);

        assertEquals(receivedMsg.getMessage(), expectedMsg);
    }

    @Test
    void testException_When_Empty_Name() {

        InvalidInputException exp = assertThrows(InvalidInputException.class, () -> {
            greetingService.greet("");
        });

        assertEquals("Invalid Input", exp.getMessage());
    }

    @Test
    void testException_When_Invalid_Name() {

        InvalidInputException exp = assertThrows(InvalidInputException.class, () -> {
            greetingService.greet("priyan");
        });

        assertEquals("Invalid Input", exp.getMessage());
    }
}
