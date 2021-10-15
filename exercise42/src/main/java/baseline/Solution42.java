/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution42
{
    public static void main(String[] args) throws IOException
    {
        CSVToTabular cTab = new CSVToTabular();

        // Read CSV
        cTab.readCSV("exercise42_input.txt");

        // Print formatted table
        System.out.print(cTab.employeeCSVToTable());

        // Exit
        System.exit(0);
    }
}

class CSVToTabular
{
    private final ArrayList<ArrayList<String>> data = new ArrayList<>();

    private final Path currentPath = Paths.get(System.getProperty("user.dir"));
    private final String[] header = {"Last", "First", "Salary"};

    private Path getPathFromFileName(String fileName)
    {
        // Try to convert fileName to Path object
        return Paths.get(currentPath.toString(), "data", fileName);
    }

    public void readCSV(String inputFileName) throws IOException
    {
        try(Scanner fromFile = new Scanner(getPathFromFileName(inputFileName)))
        {
            // While there are lines to read from the file
            while(fromFile.hasNext())
            {
                // Read a line
                // Split by commas and put this data in an ArrayList
                ArrayList<String> line = new ArrayList<>(Arrays.stream(fromFile.nextLine().split(",")).toList());

                // Add this ArrayList to the data ArrayList
                data.add(line);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File at " + getPathFromFileName(inputFileName) + " not found!");
        }
    }

    public String employeeCSVToTable()
    {
        StringBuilder output = new StringBuilder();
        String rowFormat = "%-" + getFieldWidth(0)
                + "s%-" + getFieldWidth(1)
                + "s%-" + getFieldWidth(2) + "s%n";
        // Add header to buffer
        output.append(String.format(rowFormat, header[0], header[1], header[2]));

        // Add divider to buffer
        output.append("-".repeat(getDividerLength()));
        output.append('\n');

        // For each row in data
        for(ArrayList<String> row : data)
        {
            // Add formatted row to buffer
            output.append(String.format(rowFormat, row.get(0), row.get(1), row.get(2)));
        }

        return output.toString();
    }

    private int getDividerLength()
    {
        int sum = 0;

        // Return the sum of the field widths of each column
        for(int i = 0; i < data.get(0).size(); i++)
        {
            sum += getFieldWidth(i);
        }

        return sum;
    }

    private int getFieldWidth(int column)
    {
        int max = header[column].length();

        // Find the length of the longest entry in this column
        for (ArrayList<String> datum : data)
        {
            max = Math.max(max, datum.get(column).length());
        }

        // Return this length + 2
        return max + 2;
    }

    public List<ArrayList<String>> getData()
    {
        return data;
    }
}
