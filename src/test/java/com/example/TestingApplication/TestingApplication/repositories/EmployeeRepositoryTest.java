package com.example.TestingApplication.TestingApplication.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testFindByEmail_whenEmailIsValid_thenReturnEmployee() {

    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployee(){

    }
}