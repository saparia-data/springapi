package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final List<String> messages = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/messages")
    public List<String> getMessages() {
        System.out.println("getting all message.........");
        return messages;
    }

    @PostMapping("/messages")
    public String addMessage(@RequestBody String message) {
        messages.add(message);
        System.out.println("inserting message.........");
        return "Message added: " + message;
    }

    @PutMapping("/messages/{index}")
    public String updateMessage(@PathVariable int index, @RequestBody String updatedMessage) {
        if (index < messages.size()) {
            messages.set(index, updatedMessage);
            System.out.println("updating message.........");
            return "Message updated at index " + index + ": " + updatedMessage;
        } else {
            return "Invalid index";
        }
    }

    @DeleteMapping("/messages/{index}")
    public String deleteMessage(@PathVariable int index) {
        if (index < messages.size()) {
            String removedMessage = messages.remove(index);
            System.out.println("removing message.........");
            return "Message removed at index " + index + ": " + removedMessage;
        } else {
            return "Invalid index";
        }
    }
}