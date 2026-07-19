package com.example.swed_demo.invoices;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoicesService {

    private final InvoicesRepository repository;

    public InvoicesService(InvoicesRepository repository) {
        this.repository = repository;
    }


    public List<InvoicesResponse> getUnpaidInvoices() {

        return repository.getUnpaidInvoices();
    }
}