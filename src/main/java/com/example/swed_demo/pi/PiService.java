package com.example.swed_demo.pi;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class PiService {


    private final PiRepository repository;


    public PiService(PiRepository repository) {
        this.repository = repository;
    }


    public PiResponse getPi(int precision) {

        BigDecimal pi =
                repository.getPi(precision);


        return new PiResponse(
                precision,
                pi
        );
    }
}