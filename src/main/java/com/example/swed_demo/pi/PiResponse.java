package com.example.swed_demo.pi;

import java.math.BigDecimal;

public class PiResponse {

    private int precision;
    private BigDecimal  pi;


    public PiResponse(int precision, BigDecimal pi) {
        this.precision = precision;
        this.pi = pi;
    }


    public int getPrecision() {
        return precision;
    }


    public BigDecimal getPi() {
        return pi;
    }
}