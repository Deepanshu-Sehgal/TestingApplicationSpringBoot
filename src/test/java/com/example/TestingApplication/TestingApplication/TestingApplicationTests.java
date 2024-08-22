package com.example.TestingApplication.TestingApplication;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//@SpringBootTest
@Slf4j
class TestingApplicationTests {

    @Test
//	@Disabled
    void contextLoads() {
        log.info("Test Number One");
    }

    @Test
//	@DisplayName("displayTestTwo")
    void testNumberTwo() {
		log.info("Test Number Two");

    }

}