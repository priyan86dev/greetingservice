package com.typebdigital.greetingservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GreetingMessageDto {

    private String message;
}
