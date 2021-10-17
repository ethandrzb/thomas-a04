/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Solution45
{
    private static final Scanner sc = new Scanner(System.in);
    private final Path currentPath = Paths.get(System.getProperty("user.dir"));

    public static void main(String[] args)
    {
        Solution45 sol = new Solution45();
        String outputFileName;

        // Prompt user for output filename
        System.out.print("Output filename: ");
        outputFileName = sc.nextLine();

        // Find and replace all occurrences of "utilize" with "use"
        sol.findAndReplace("exercise45_input.txt", outputFileName);

        // Exit
        System.exit(0);
    }

    public void findAndReplace(String inputFileName, String outputFileName)
    {
        // Attempt to read input text file
        try(Scanner fromFile = new Scanner(getPathFromFileName(inputFileName)))
        {
            executeFindAndReplace(fromFile, outputFileName);
        }
        catch(IOException e1)
        {
            System.out.println("Unable to open input file at " + getPathFromFileName(inputFileName));
        }
    }

    private void executeFindAndReplace(Scanner fromFile, String outputFileName)
    {
        String line;
        String target = "utilize";
        String replacement = "use";

        // Attempt to open/create output text file
        try(Formatter output = new Formatter(getPathFromFileName(outputFileName).toString()))
        {
            // while there are still lines of text to read from the input file
            while(fromFile.hasNext())
            {
                // Read single line
                line = fromFile.nextLine();

                // Replace all occurrences of the word "utilize" with use
                line = line.replace(target, replacement);

                // Write to output file
                output.format("%s%n", line);
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
