/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyFinderTest
{
    WordFrequencyFinder wff;

    @BeforeEach
    void init()
    {
         wff = new WordFrequencyFinder();
    }

    @Test
    void getWordFrequencies_Case_1()
    {
        wff.getWordFrequencies("exercise46_input_test_1.txt");

        HashMap<String, Integer> actual = (HashMap<String, Integer>) wff.getWordFrequencyMap();

        // 3 unique words in test data
        assertEquals(3, actual.keySet().size());
        String[] expectedWords = {"badger", "mushroom", "snake"};
        int[] expectedFrequencies = {7, 2, 1};

        for(int i = 0; i < actual.keySet().size(); i++)
        {
            // Test if expected word was registered
            assertTrue(actual.containsKey(expectedWords[i]));

            // Test frequency for that word
            assertEquals(expectedFrequencies[i], actual.get(expectedWords[i]));
        }
    }

    @Test
    void getWordFrequencies_Case_2()
    {
        wff.getWordFrequencies("exercise46_input_test_2.txt");

        HashMap<String, Integer> actual = (HashMap<String, Integer>) wff.getWordFrequencyMap();

        // 9 unique words in test data
        assertEquals(9, actual.keySet().size());
        String[] expectedWords = {"sadf", "aa", "aaa", "a", "fwe", "77", "asdf", "a90", "90a"};
        int[] expectedFrequencies = {5, 2, 2, 2, 2, 1, 1, 1, 1};

        for(int i = 0; i < actual.keySet().size(); i++)
        {
            // Test if expected word was registered
            assertTrue(actual.containsKey(expectedWords[i]));

            // Test frequency for that word
            assertEquals(expectedFrequencies[i], actual.get(expectedWords[i]));
        }
    }

    @Test
    void sortWordList()
    {
        ArrayList<String> actual;

        wff.getWordFrequencies("exercise46_input_test_1.txt");

        String[] expectedBeforeSort = {"snake", "mushroom", "badger"};
        actual = (ArrayList<String>) wff.getWordList();

        // Test if word list was created correctly
        for(int i = 0; i < actual.size(); i++)
        {
            assertEquals(expectedBeforeSort[i], actual.get(i));
        }

        wff.sortWordList();
        actual = (ArrayList<String>) wff.getWordList();
        String[] expectedAfterSort = {"badger", "mushroom", "snake"};

        for(int i = 0; i < actual.size(); i++)
        {
            assertEquals(expectedAfterSort[i], actual.get(i));
        }
    }

    @Test
    void generateOutput()
    {
        wff.getWordFrequencies("exercise46_input_test_1.txt");

        wff.sortWordList();

        String[] actual = wff.generateOutput().split("\r\n");
        String[] expected = """
                badger:   *******
                mushroom: **
                snake:    *
                """.split("\n");

        for(int i = 0; i < actual.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }
}