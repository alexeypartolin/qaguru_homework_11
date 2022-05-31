package properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void someTest() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
}
