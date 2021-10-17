/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Solution45Test
{
    private final Path currentPath = Paths.get(System.getProperty("user.dir"));

    @Test
    void findAndReplace()
    {
        Solution45 sol = new Solution45();
        String outputFileName;

        // Prompt user for output filename
        System.out.print("Output filename: ");
        outputFileName = "exercise45_output_test_1_txt";

        // Find and replace all occurrences of "utilize" with "use"
        sol.findAndReplace("exercise45_input_test_1.txt", outputFileName);

        String[] expected = """
                One should never use the word "use" in writing. Use "use" instead.
                For example, "She uses an IDE to write her Java programs" instead of "She
                uses an IDE to write her Java programs".
                """.split("\n");

        assertTrue(Files.exists(getPathFromFileName(outputFileName)));

        int lineNumber = 0;

        try(Scanner fromFile = new Scanner(new File(getPathFromFileName(outputFileName).toString())))
        {
            while(fromFile.hasNext())
            {
                assertEquals(expected[lineNumber], fromFile.nextLine());
                lineNumber++;
            }
        }
        catch(FileNotFoundException e2)
        {
            System.out.println("Unable to open output file at " + getPathFromFileName(outputFileName));
        }
    }

    private Path getPathFromFileName(String fileName)
    {
        return Paths.get(currentPath.toString(), "data", fileName);
    }
}