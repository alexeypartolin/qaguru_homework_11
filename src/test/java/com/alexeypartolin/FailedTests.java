package com.alexeypartolin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FailedTests {
    @Test
    @Tag("demoTests")
    @DisplayName("Failed simple test")
    public void NegativeSimpleTest() {
        assertTrue(false);
    }
}
