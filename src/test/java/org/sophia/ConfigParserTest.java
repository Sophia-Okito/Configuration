package org.sophia;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.sophia.configuration.ConfigParser;

public class ConfigParserTest{
    /**
     * Test ConfigParser using default file.
     */
    ConfigParser config = new ConfigParser("");
    @Test
    public void getTest() {
        String expectedTheme = "green";
        String expectedDbName = "sq04_db";
        assertEquals(expectedTheme, config.get("application.theme"));
        assertEquals(expectedDbName, config.get("dbname"));
    }
}
