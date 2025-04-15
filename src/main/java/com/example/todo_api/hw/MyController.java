package com.example.todo_api.hw;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MyController {
    private final MyService myService;

    public void controllerMethod() {
        System.out.println("controller");
        myService.serviceMethod();
    }
}
