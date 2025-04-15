package com.example.todo_api.hw;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MyService {
    private final MyRepository myRepository;

    public void serviceMethod() {
        System.out.println("service");
        myRepository.repositoryMethod();
    }
}
