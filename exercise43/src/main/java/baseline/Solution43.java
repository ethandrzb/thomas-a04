/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

public class Solution43
{
    public static void main(String[] args)
    {
        // Generate website

        // Exit
    }
}
class WebsiteGenerator
{
    public WebsiteGenerator(String siteName, String authorName)
    {
        // Initialize instance variables

        // Get current path
    }

    public void configureSite()
    {
        // Prompt user for website name

        // Prompt user for name of website author

        // Ask user if they want a folder created for JS files

        // Ask user if they want a folder created for CSS files
    }

    private boolean getYesNoFromUser(String prompt)
    {
        // while user input is invalid
            // Display prompt
            // Read user input
                // If "Y", return true
                // Else if "N", return false
                // Else, print invalid input
    }

    public void generateSite()
    {
        // Make root folder for site (./website/siteName)

        // Generate index.html

        // Make folder for JS files, if applicable

        // Make folder for CSS files, if applicable
    }

    private void createDirAndDisplayPath(String directoryName)
    {
        // Generate path to new directory

        // Try to make directory
            // If successful, display path to new directory
            // Else, display error message
    }
}