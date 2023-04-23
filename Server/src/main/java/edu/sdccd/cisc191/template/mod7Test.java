package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Adapted from Tasha Frankie and Allan Schougaard
 */

class mod7Test
{


    @Test
    void testReadTestResultsDoesNotExist()
    {
        String results = mod7.readTestResults("IDoNotExist.csv");
        assertEquals("", results);
    }

    @Test
    void testReadDateTime()
    {
        // You can see that the server responds with by entering the URL in a browser
        // and selecting Raw Data
        String dateTime = mod7.readDateTime("http://worldtimeapi.org/api/ip");
        // Hint: use String's indexOf("\"datetime\":\", 0)
        assertTrue(dateTime.startsWith("202"));
        assertTrue(dateTime.contains("T"));
        assertTrue(dateTime.endsWith("-07:00")); // unless you are on a different timezone
    }
}