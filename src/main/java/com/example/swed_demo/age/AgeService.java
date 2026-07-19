package com.example.swed_demo.age;


import org.springframework.stereotype.Service;


@Service
public class AgeService {


    private final AgeRepository repository;


    public AgeService(AgeRepository repository) {
        this.repository = repository;
    }


    public AgeResponse getAgeBracket(int age) {

        String bracket =
                repository.getAgeBracket(age);


        return new AgeResponse(
                age,
                bracket
        );
    }
}