package com.example.swed_demo.pi;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Types;

@Repository
public class PiRepository {

    private final JdbcTemplate jdbcTemplate;

    public PiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public BigDecimal getPi(int precision) {

        return jdbcTemplate.execute(
                (CallableStatementCreator) connection -> {

                    var statement =
                            connection.prepareCall(
                                    "{ ? = call swed_homework.get_pi(?) }"
                            );

                    statement.registerOutParameter(
                            1,
                            Types.NUMERIC
                    );

                    statement.setInt(2, precision);

                    return statement;

                },
                statement -> {

                    statement.execute();

                    return statement.getBigDecimal(1);
                }
        );
    }
}