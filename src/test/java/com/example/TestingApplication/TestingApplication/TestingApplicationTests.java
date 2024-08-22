package com.example.TestingApplication.TestingApplication;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

//@SpringBootTest
@Slf4j
class TestingApplicationTests {

    @BeforeEach
    void setUp() {
        log.info("Starting the method, setting up config");
    }

    @AfterEach
    void tearDown() {
        log.info("Tearing Down the method");
    }

    @BeforeAll
    static void setUpOnce() {
        log.info("SetupOnce...");
    }

    @AfterAll
    static void tearDownOnce() {
        log.info("Tearing Down Once...");
    }

    @Test
//	@Disabled
    void contextLoads() {
        log.info("Test Number One");
    }

    @Test
//	@DisplayName("displayTestTwo")
    void testNumberTwo() {
        int a = 5;
        int b = 5;

        int results = addTwoNumbers(a, b);
//        Assertions.assertEquals(10,results);

//        assertThat(results)
//                .isEqualTo(11)
//                .isCloseTo(9, Offset.offset(1));

        assertThat("Apple").isEqualTo("Apple")
                .startsWith("App")
                .endsWith("le")
                .hasSize(5);


    }

    @Test
    void testNumberOne() {
        int a = 5, b = 0;

        assertThatThrownBy(() -> divideTwoNumbers(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Tried To Divide By Zero");

    }

    int addTwoNumbers(int a, int b) {
        return a + b;
    }

    double divideTwoNumbers(int a, int b) {
        try {

            return a / b;
        } catch (ArithmeticException e) {
            log.error("Arithmetic Exception");
            throw new ArithmeticException("Tried To Divide By Zero");
        }
    }

}