/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest
{

    @Test
    void getProductInfo()
    {
        Solution44 sol = new Solution44();

        sol.readDatabaseFromJSONFile("exercise44_input_test_1.json");

        Database actualDB = sol.getDatabase();

        // There isn't a product with the name "dgsaf" in the database, so the query should return an empty string
        assertTrue(actualDB.getProductInfo("dgsaf").isEmpty());

        assertFalse(actualDB.getProductInfo("Widget").isEmpty());
    }

    @Test
    void productToString()
    {
        Solution44 sol = new Solution44();

        sol.readDatabaseFromJSONFile("exercise44_input_test_1.json");

        Database actualDB = sol.getDatabase();

        String[] expected = """
                Name: Widget
                Price: 25.00
                Quantity: 5
                """.split("\n");

        String[] actual = actualDB.getProductInfo("Widget").split("\r\n");

        for(int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }
}