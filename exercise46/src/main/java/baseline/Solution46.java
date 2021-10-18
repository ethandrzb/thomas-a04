/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution46
{
    public static void main(String[] args)
    {
        WordFrequencyFinder wff = new WordFrequencyFinder();

        // Count frequencies of words in input file
        wff.getWordFrequencies("exercise46_input.txt");

        // Sort word frequency array by frequency
        wff.sortWordList();

        // Generate and print formatted output
        System.out.print(wff.generateOutput());

        // Exit
        System.exit(0);
    }
}
class WordFrequencyFinder
{
    private final Path currentPath = Paths.get(System.getProperty("user.dir"));
    private final ArrayList<String> words = new ArrayList<>();
    private final HashMap<String, Integer> freq = new HashMap<>();

    public void getWordFrequencies(String fileName)
    {
        String word;

        // Attempt to open input file
        try(Scanner fromFile = new Scanner(getPathFromFileName(fileName)))
        {
            // While there is input to be read
            while(fromFile.hasNext())
            {
                word = fromFile.next();

                // Check if we've seen this word before
                if(freq.containsKey(word))
                {
                    // If so, increment frequency
                    freq.put(word, freq.get(word) + 1);
                }
                else {
                    // If not, register word and set frequency to 1
                    freq.put(word, 1);
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Unable to open input file at " + getPathFromFileName(fileName));
        }

        // Copy words to sortable list
        words.addAll(freq.keySet());
    }

    public void sortWordList()
    {
        // Sort words in frequency array in order of decreasing frequency
        words.sort((o1, o2) -> freq.get(o2) - freq.get(o1));
    }

    public String generateOutput()
    {
        StringBuilder output = new StringBuilder();

        // Generate format string
        int wordFieldWidth = getFieldWidth();
        String outputFormat = "%-" + wordFieldWidth + "s%s%n";

        // For each word and associated frequency in frequency array
        for(String word : words)
        {
            // Add word to output buffer
            // Add asterisk histogram for this word to output buffer
            output.append(String.format(outputFormat, word.concat(": "), "*".repeat(freq.get(word))));
        }

        return output.toString();
    }

    private int getFieldWidth()
    {
        int max = Integer.MIN_VALUE;

        // Find length of maximum word in frequency array
        for(String word : words)
        {
            max = Math.max(max, word.length());
        }

        // Return max + 2
        // The offset of 2 provides room for the colon and space added in generateOutput
        return max + 2;
    }

    private Path getPathFromFileName(String fileName)
    {
        return Paths.get(currentPath.toString(), "data", fileName);
    }

    public Map<String, Integer> getWordFrequencyMap()
    {
        return freq;
    }

    public List<String> getWordList()
    {
        return words;
    }
}