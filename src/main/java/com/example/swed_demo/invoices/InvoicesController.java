package com.example.swed_demo.invoices;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

    private final InvoicesService service;

    public InvoicesController(InvoicesService service) {
        this.service = service;
    }


    @GetMapping("/unpaid")
    public List<InvoicesResponse> getUnpaidInvoices() {

        return service.getUnpaidInvoices();
    }
}