/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution42
{
    public static void main(String[] args)
    {
        // Read CSV

        // Write data from CSV to another file in tabular format

        // Exit
    }
}

class CSVToTabular
{
    private ArrayList<ArrayList<String>> data;

    private final Path currentPath;

    private Path getPathFromFileName(String fileName)
    {
        // Try to convert fileName to Path object
    }

    public void readCSV(String inputFileName)
    {
        // While there are lines to read from the file
            // Read a line
            // Split by commas and put this data in an ArrayList
            // Add this ArrayList to the data ArrayList
    }

    public void employeeCSVToTable(String outputFileName)
    {
        // read CSV

        // Create output file

        // Get padding for each column

        // Write header to file

        // Write divider to file

        // While there are rows of entries to be written
            // Write formatted row to file
    }

    private int getDividerLength()
    {
        // Return the sum of the field widths of each columns
    }

    private int getFieldWidth(int column)
    {
        // Find the length of the longest entry in this column

        // Return this length + 2
    }
}
