/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution41
{
    public static void main(String[] args) throws IOException
    {
        NameSorter ns = new NameSorter();

        // Read input file and store in sortable data structure
        ns.readNameList();

        // Sort data structure by last name
        ns.sortNameList();

        // Generate output
        String output = ns.generateOutput();

        // Write output to file
        ns.writeNameList(output);

        // Exit
        System.exit(0);
    }
}

class NameSorter
{
    private static final String FIRST_NAME = "FIRST_NAME";
    private static final String LAST_NAME = "LAST_NAME";
    private static final Path currentPath = Paths.get(System.getProperty("user.dir"));
    private static final Path inputPath = Paths.get(currentPath.toString(), "data", "exercise41_input.txt");
    private static final Path outputPath = Paths.get(currentPath.toString(), "data", "exercise41_output.txt");
    private final ArrayList<HashMap<String, String>> names;

    public NameSorter()
    {
        names = new ArrayList<>();
    }

    public NameSorter(List<HashMap<String, String>> names)
    {
        this.names = (ArrayList<HashMap<String, String>>) names;
    }

    public void readNameList() throws IOException
    {
        String[] current;
        // Open input file
        Scanner fromFile = new Scanner(inputPath);

        // While there are still names to be read
        while(fromFile.hasNext())
        {
            current = fromFile.nextLine().split(", ");
            HashMap<String, String> hs = new HashMap<>();

            // Add last name to map
            hs.put(LAST_NAME, current[0]);

            // Add first name to map
            hs.put(FIRST_NAME, current[1]);

            // Add map to list
            names.add(hs);
        }

        fromFile.close();
    }

    public void writeNameList(String output) throws IOException
    {
        PrintWriter pw = new PrintWriter(outputPath.toString());

        pw.print(output);

        pw.close();
    }

    public void sortNameList()
    {
        names.sort((o1, o2) -> {
            // Compare last names
            if (o1.get(LAST_NAME).compareTo(o2.get(LAST_NAME)) != 0)
            {
                return o1.get(LAST_NAME).compareTo(o2.get(LAST_NAME));
            }
            // Last names are identical ==> Compare first names
            else
            {
                return o1.get(FIRST_NAME).compareTo(o2.get(FIRST_NAME));
            }
        });
    }

    public String generateOutput()
    {
        StringBuilder output = new StringBuilder();
        String line;

        // Add number of names in list to output buffer
        String header = "Total of " + names.size() + " names\n";
        output.append(header);

        // Add dynamically sized divider to output buffer
        output.append("-".repeat(getDividerLength()));
        output.append('\n');

        // Add each name from sorted list to output buffer in the form of last_name, first_name
        for(HashMap<String, String> hs : names)
        {
            line = hs.get(LAST_NAME) + ", " + hs.get(FIRST_NAME) + "\n";
            output.append(line);
        }

        // Return buffer
        return output.toString();

    }
    private int getDividerLength()
    {
        int max = Integer.MIN_VALUE;
        int nameLength;

        // Find length of longest name in list + 2
        for(HashMap<String, String> hs : names)
        {
            nameLength = hs.get(FIRST_NAME).length() + hs.get(LAST_NAME).length();
            max = Math.max(max, nameLength);
        }

        // Return length
        return max + 2;
    }
}