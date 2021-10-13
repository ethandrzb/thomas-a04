/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest
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
    void sortNameList()
    {
        // Get test data
        ArrayList<HashMap<String, String>> testNames = generateTestData();

        NameSorter ns = new NameSorter(testNames);

        ns.sortNameList();

        assertEquals("aw", testNames.get(0).get(FIRST_NAME));
        assertEquals("ab", testNames.get(0).get(LAST_NAME));

        assertEquals("zza", testNames.get(1).get(FIRST_NAME));
        assertEquals("ab", testNames.get(1).get(LAST_NAME));

        assertEquals("ws", testNames.get(2).get(FIRST_NAME));
        assertEquals("abc", testNames.get(2).get(LAST_NAME));

        assertEquals("wr", testNames.get(3).get(FIRST_NAME));
        assertEquals("dbc", testNames.get(3).get(LAST_NAME));
    }

    @Test
    void readNameList() throws IOException
    {
        int i = 0;
        String[] fieldList = {LAST_NAME, FIRST_NAME};
        String[] expected = {"Ling", "Mai",
                            "Johnson", "Jim",
                            "Zarnecki", "Sabrina",
                            "Jones", "Chris",
                            "Jones", "Aaron",
                            "Swift", "Geoffrey",
                            "Xiong", "Fong"};

        NameSorter ns = new NameSorter();

        ns.readNameList("exercise41_input.txt");

        ArrayList<HashMap<String, String>> actualNames = (ArrayList<HashMap<String, String>>) ns.getNames();

        for(HashMap<String, String> hs : actualNames)
        {
            for(String field : fieldList)
            {
                assertEquals(expected[i], hs.get(field));
                i++;
            }
        }
    }

    @Test
    void writeNameList() throws IOException
    {
        String[] expected = """
                Total of 7 names
                -----------------
                Johnson, Jim
                Jones, Aaron
                Jones, Chris
                Ling, Mai
                Swift, Geoffrey
                Xiong, Fong
                Zarnecki, Sabrina
                """.split("\n");
        NameSorter ns = new NameSorter();

        ns.readNameList("exercise41_input.txt");

        ns.sortNameList();

        String output = ns.generateOutput();

        ns.writeNameList("exercise41_output.txt", output);

        Scanner sc = new Scanner(new File("data/exercise41_output.txt"));

        // Read generated file
        for(String line : expected)
        {
            assertEquals(line, sc.nextLine());
        }
    }
}