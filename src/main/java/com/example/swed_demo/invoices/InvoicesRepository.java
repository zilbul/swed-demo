package com.example.swed_demo.invoices;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class InvoicesRepository {

    private final SimpleJdbcCall jdbcCall;


    public InvoicesRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("SWED_HOMEWORK")
                .withFunctionName("GET_UNPAID_INVOICES")
                .returningResultSet(
                        "return",
                        (rs, rowNum) -> new InvoicesResponse(
                                rs.getInt("invoice_id"),
                                rs.getDate("invoice_date").toLocalDate()
                        )
                );
    }


    public List<InvoicesResponse> getUnpaidInvoices() {

        Map<String, Object> result =
                jdbcCall.execute();

        return (List<InvoicesResponse>) result.get("return");
    }
}