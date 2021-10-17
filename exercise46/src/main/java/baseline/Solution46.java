/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

public class Solution46
{
    public static void main(String[] args)
    {
        // Count frequencies of words in input file

        // Sort word frequency array by frequency

        // Generate and print formatted output

        // Exit
    }
}
class WordFrequencyFinder
{
    public void getWordFrequencies(String fileName)
    {
        // Attempt to open input file
            // While there are lines of input to read
                // Check if we've seen this word before
                    // If so, increment frequency
                    // If not, register word and set frequency to 1
    }

    public void sortWordFrequencyArray()
    {
        // Sort words in frequency array in order of decreasing frequency
    }

    public String generateOutput()
    {
        // Generate format string

        // For each word and associated frequency in frequency array
            // Add word to output buffer
            // Add asterisk histogram for this word to output buffer
    }

    private int getFieldWidth()
    {
        // Find length of maximum word in frequency array

        // Return this maximum + 2 (room for color and extra space)
    }
}