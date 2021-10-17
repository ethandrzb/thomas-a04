/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Solution44Test
{
    @Test
    void readDatabaseFromJSONFile()
    {
        Solution44 sol = new Solution44();

        sol.readDatabaseFromJSONFile("exercise44_input_test_1.json");

        Database actualDB = sol.getDatabase();
        HashMap<String, Product> actualProductMap = (HashMap<String, Product>) actualDB.getProductDatabase();
        Product p;

        assertTrue(actualProductMap.containsKey("Widget"));
        p = actualProductMap.get("Widget");
        assertEquals("Widget", p.getName());
        assertEquals(25.00, p.getPrice());
        assertEquals(5, p.getQuantity());

        assertTrue(actualProductMap.containsKey("Thing"));
        p = actualProductMap.get("Thing");
        assertEquals("Thing", p.getName());
        assertEquals(15.00, p.getPrice());
        assertEquals(5, p.getQuantity());

        assertTrue(actualProductMap.containsKey("Doodad"));
        p = actualProductMap.get("Doodad");
        assertEquals("Doodad", p.getName());
        assertEquals(5.00, p.getPrice());
        assertEquals(10, p.getQuantity());
    }
}