package com.alexeypartolin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessTests {
    @Test
    @Tag("demoTests")
    @DisplayName("Successful simple test 1")
    public void PositiveSimpleTest1() {
        assertTrue(true);
    }

    @Test
    @Tag("demoTests")
    @DisplayName("Successful simple test 2")
    public void PositiveSimpleTest2() {
        assertTrue(true);
    }
}
