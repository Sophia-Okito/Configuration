package org.sophia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sophia.configuration.MapGenerator;

public class MapGeneratorTest {
    /**
     * Test MapGenerator class using default file.
     */

    MapGenerator mapGen = new MapGenerator("");
    @Test
    public void getTest() {
        String expectedTheme = "green";
        String expectedDbName = "sq04_db";
        String expectedHost = "127.0.0.1";
        assertEquals(expectedTheme, mapGen.mapGen().get("application.theme"));
        assertEquals(expectedDbName, mapGen.mapGen().get("dbname"));
        assertEquals(expectedHost, mapGen.mapGen().get("host"));
    }
}
