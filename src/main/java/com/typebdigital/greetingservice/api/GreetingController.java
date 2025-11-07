package com.typebdigital.greetingservice.api;

import com.typebdigital.greetingservice.dto.GreetingMessageDto;
import com.typebdigital.greetingservice.service.GreetingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/hello-world")
    public ResponseEntity<GreetingMessageDto> greeting(@RequestParam String name) {
        return ResponseEntity.ok(greetingService.greet(name));
    }
}
