/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution43
{
    public static void main(String[] args)
    {
        WebsiteGenerator wg = new WebsiteGenerator();

        // Configure website
//        wg.configureSite();

        // Generate website
        wg.generateSite();

        // Exit
        System.exit(0);
    }
}
class WebsiteGenerator
{
    private static final Scanner sc = new Scanner(System.in);
    private final Path currentPath = Paths.get(System.getProperty("user.dir"));

    private String websiteName = "";
    private String authorName = "";

    private boolean makeJSFolder = false;
    private boolean makeCSSFolder = false;

    private Path getPathFromFileName(String fileName)
    {
        // Try to convert fileName to Path object
        return Paths.get(currentPath.toString(), "data", fileName);
    }

    public void configureSite()
    {
        // Prompt user for website name
        System.out.print("Site name: ");
        websiteName = sc.nextLine();

        // Prompt user for name of website author
        System.out.print("Author: ");
        authorName = sc.nextLine();

        // Ask user if they want a folder created for JS files
        makeJSFolder = getYesNoFromUser("Do you want a folder for JavaScript?");

        // Ask user if they want a folder created for CSS files
        makeCSSFolder = getYesNoFromUser("Do you want a folder for CSS?");
    }

    private boolean getYesNoFromUser(String prompt)
    {
        String userInput;

        // while user input is invalid
        while(true)
        {
            System.out.print(prompt + " ");

            // Read user input
            userInput = sc.nextLine().toUpperCase();

            if(userInput.equals("Y"))
            {
                return true;
            }
            else if(userInput.equals("N"))
            {
                return false;
            }
            else
            {
                System.out.println("Invalid choice entered. Enter 'Y' for yes or 'N' for no.");
            }
        }
    }

    public void generateSite()
    {
        // Make root folder for site (./website/siteName)
        new File(Paths.get(currentPath.toString(),"data",  "website", websiteName).toString()).mkdirs();

        // Generate index.html

        // Make folder for JS files, if applicable

        // Make folder for CSS files, if applicable
    }

    private void generateSiteIndex(Path siteRoot)
    {

    }

    private void createDirAndDisplayPath(String directoryName)
    {
        // Generate path to new directory

        // Try to make directory
            // If successful, display path to new directory
            // Else, display error message
    }
}