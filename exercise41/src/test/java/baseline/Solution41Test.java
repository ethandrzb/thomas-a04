/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test
{
    static final String FIRST_NAME = "FIRST_NAME";
    static final String LAST_NAME = "LAST_NAME";

    ArrayList<HashMap<String, String>> generateTestData()
    {
        ArrayList<HashMap<String, String>> testNames = new ArrayList<>();

        // Generate test data
        HashMap<String, String> p1 = new HashMap<>();
        HashMap<String, String> p2 = new HashMap<>();
        HashMap<String, String> p3 = new HashMap<>();
        HashMap<String, String> p4 = new HashMap<>();

        p1.put(FIRST_NAME, "zza");
        p1.put(LAST_NAME, "ab");
        testNames.add(p1);

        p2.put(FIRST_NAME, "aw");
        p2.put(LAST_NAME, "ab");
        testNames.add(p2);

        p3.put(FIRST_NAME, "wr");
        p3.put(LAST_NAME, "dbc");
        testNames.add(p3);

        p4.put(FIRST_NAME, "ws");
        p4.put(LAST_NAME, "abc");
        testNames.add(p4);

        return testNames;
    }

    @Test
    void sortNameList() {
        Solution41 sol = new Solution41();

        // Get test data
        ArrayList<HashMap<String, String>> testNames = generateTestData();

        sol.sortNameList(testNames);

        assertEquals("aw", testNames.get(0).get(FIRST_NAME));
        assertEquals("ab", testNames.get(0).get(LAST_NAME));

        assertEquals("zza", testNames.get(1).get(FIRST_NAME));
        assertEquals("ab", testNames.get(1).get(LAST_NAME));

        assertEquals("ws", testNames.get(2).get(FIRST_NAME));
        assertEquals("abc", testNames.get(2).get(LAST_NAME));

        assertEquals("wr", testNames.get(3).get(FIRST_NAME));
        assertEquals("dbc", testNames.get(3).get(LAST_NAME));
    }
}