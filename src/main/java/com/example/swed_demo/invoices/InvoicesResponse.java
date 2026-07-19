package com.example.swed_demo.invoices;

import java.time.LocalDate;

public class InvoicesResponse {

    private int invoiceId;
    private LocalDate invoiceDate;


    public InvoicesResponse(int invoiceId, LocalDate invoiceDate) {

        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
    }


    public int getInvoiceId() {
        return invoiceId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }


}