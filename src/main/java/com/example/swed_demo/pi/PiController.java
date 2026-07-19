package com.example.swed_demo.pi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/pi")
public class PiController {


    private final PiService service;


    public PiController(PiService service) {
        this.service = service;
    }


    @GetMapping("/{precision}")
    public PiResponse getPi(
            @PathVariable int precision) {

        return service.getPi(precision);
    }
}