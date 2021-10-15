/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVToTabularTest {

    @Test
    void readCSV() throws IOException
    {
        CSVToTabular cTab = new CSVToTabular();

        // Read CSV
        cTab.readCSV("exercise42_input.txt");

        ArrayList<ArrayList<String>> actual = (ArrayList<ArrayList<String>>) cTab.getData();

        assertEquals("Ling", actual.get(0).get(0));
        assertEquals("Mai", actual.get(0).get(1));
        assertEquals("55900", actual.get(0).get(2));

        assertEquals("Johnson", actual.get(1).get(0));
        assertEquals("Jim", actual.get(1).get(1));
        assertEquals("56500", actual.get(1).get(2));

        assertEquals("Jones", actual.get(2).get(0));
        assertEquals("Aaron", actual.get(2).get(1));
        assertEquals("46000", actual.get(2).get(2));

        assertEquals("Jones", actual.get(3).get(0));
        assertEquals("Chris", actual.get(3).get(1));
        assertEquals("34500", actual.get(3).get(2));

        assertEquals("Swift", actual.get(4).get(0));
        assertEquals("Geoffrey", actual.get(4).get(1));
        assertEquals("14200", actual.get(4).get(2));

        assertEquals("Xiong", actual.get(5).get(0));
        assertEquals("Fong", actual.get(5).get(1));
        assertEquals("65000", actual.get(5).get(2));

        assertEquals("Zarnecki", actual.get(6).get(0));
        assertEquals("Sabrina", actual.get(6).get(1));
        assertEquals("51500", actual.get(6).get(2));
    }

    @Test
    void employeeCSVToTable() throws IOException
    {
        String[] expected = """
                Last      First     Salary \s\r
                ----------------------------
                Ling      Mai       55900  \s\r
                Johnson   Jim       56500  \s\r
                Jones     Aaron     46000  \s\r
                Jones     Chris     34500  \s\r
                Swift     Geoffrey  14200  \s\r
                Xiong     Fong      65000  \s\r
                Zarnecki  Sabrina   51500  \s\r
                """.split("\n");

        CSVToTabular cTab = new CSVToTabular();

        // Read CSV
        cTab.readCSV("exercise42_input.txt");

        String[] actual = cTab.employeeCSVToTable().split("\n");

        for(int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }
}