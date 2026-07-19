package com.example.swed_demo.age;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public class AgeRepository {

    private final JdbcTemplate jdbcTemplate;

    public AgeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String getAgeBracket(int age) {

        return jdbcTemplate.execute(
                (CallableStatementCreator) connection -> {

                    var statement =
                            connection.prepareCall(
                                    "{ ? = call swed_homework.get_age_bracket(?) }"
                            );

                    statement.registerOutParameter(
                            1,
                            Types.VARCHAR
                    );

                    statement.setInt(2, age);

                    return statement;

                },
                statement -> {

                    statement.execute();

                    return statement.getString(1);
                }
        );
    }
}