package com.example.swed_demo.age;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/age")
public class AgeController {


    private final AgeService service;


    public AgeController(AgeService service) {
        this.service = service;
    }


    @GetMapping("/{age}")
    public AgeResponse getAge(
            @PathVariable int age) {

        return service.getAgeBracket(age);
    }
}