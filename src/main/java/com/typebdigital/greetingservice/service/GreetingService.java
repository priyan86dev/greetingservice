package com.typebdigital.greetingservice.service;

import com.typebdigital.greetingservice.dto.GreetingMessageDto;
import com.typebdigital.greetingservice.exception.InvalidInputException;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public GreetingMessageDto greet(String name) {

        if (name.isEmpty())
            throw new InvalidInputException("Invalid Input");

        if (isFirstLetterInFirstHalfOfAlphabet(name)) {

            StringBuilder formattedName = new StringBuilder();
            formattedName.append(name.substring(0, 1).toUpperCase()).append(name.substring(1));

            return GreetingMessageDto.builder().message("Hello " + formattedName).build();
        } else {
            throw new InvalidInputException("Invalid Input");
        }
    }

    // Checking whether first letter of the name is in the first half of Alphabet
    private boolean isFirstLetterInFirstHalfOfAlphabet(String name) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        int midPointOfAlphabet = alphabet.length() / 2;
        String firstHalfOfAlphabet = alphabet.substring(0, midPointOfAlphabet);

        return (firstHalfOfAlphabet.indexOf(convertFirstLetterToLowerCase(name.charAt(0))) != -1);
    }

    // If first letter is in upper-case -> convert it into lower-case
    private char convertFirstLetterToLowerCase(char firstLetter) {
        return Character.isUpperCase(firstLetter) ? Character.toLowerCase(firstLetter) : firstLetter;
    }
}
