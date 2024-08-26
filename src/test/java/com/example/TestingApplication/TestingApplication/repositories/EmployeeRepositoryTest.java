package com.example.TestingApplication.TestingApplication.repositories;

import com.example.TestingApplication.TestingApplication.TestContainerConfig;
import com.example.TestingApplication.TestingApplication.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//@SpringBootTest
@Import(TestContainerConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .id(1L)
                .name("Deep")
                .email("Deepa@gmail.com")
                .salary(100L)
                .build();
    }

    @Test
    void testFindByEmail_whenEmailIsValid_thenReturnEmployee() {
        //Arrange Given
        employeeRepository.save(employee);
        //act,When
        List<Employee> employeeList = employeeRepository.findByEmail(employee.getEmail());


        //assert, Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());

    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployee() {
        //Given
        String email = "notPresent.123@gmail.com";
        //When
        List<Employee> employeeList = employeeRepository.findByEmail(email);
        //Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();
    }
}