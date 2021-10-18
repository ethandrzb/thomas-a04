/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Solution43
{
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution43 sol = new Solution43();

        String websiteName;
        String authorName;
        boolean createJSFolder;
        boolean createCSSFolder;

        // Prompt user for website name
        System.out.print("Site name: ");
        websiteName = sc.nextLine();

        // Prompt user for name of website author
        System.out.print("Author: ");
        authorName = sc.nextLine();

        // Ask user if they want a folder created for JS files
        createJSFolder = sol.getYesNoFromUser("Do you want a folder for JavaScript?");

        // Ask user if they want a folder created for CSS files
        createCSSFolder = sol.getYesNoFromUser("Do you want a folder for CSS?");

        // Configure website
        WebsiteGenerator wg = new WebsiteGenerator(websiteName, authorName, createJSFolder, createCSSFolder);

        // Generate website
        wg.generateSite();

        // Exit
        System.exit(0);
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
}

class WebsiteGenerator
{
    private final Path currentPath = Paths.get(System.getProperty("user.dir"), "data");
    private Path siteRoot;

    private static final String FILE_CREATION_HEADER = "Created ";

    private final String websiteName;
    private final String authorName;

    private final boolean createJSFolder;
    private final boolean createCSSFolder;

    public WebsiteGenerator(String websiteName, String authorName, boolean createJSFolder, boolean createCSSFolder)
    {
        this.websiteName = websiteName;
        this.authorName = authorName;

        this.createJSFolder = createJSFolder;
        this.createCSSFolder = createCSSFolder;
    }

    public void generateSite()
    {
        siteRoot = Paths.get(currentPath.toString(),  "website", websiteName);

        // Make root folder for site (./website/siteName)
        boolean success = new File(siteRoot.toString()).mkdirs();

        if(success)
        {
            System.out.println(FILE_CREATION_HEADER + siteRoot.toString().replaceFirst(
                    currentPath.toString().replace("\\", "\\\\"), "."));
        }
        else
        {
            System.out.println("Unable to create website root directory in " + siteRoot.toString());
        }

        // Generate index.html
        generateSiteIndex();

        // Make folder for JS files, if applicable
        if(createJSFolder)
        {
            createDirAndDisplayPath("js");
        }

        // Make folder for CSS files, if applicable
        if(createCSSFolder)
        {
            createDirAndDisplayPath("css");
        }
    }

    private void generateSiteIndex()
    {
        String indexFileName = "index.html";
        try(Formatter output = new Formatter(Paths.get(siteRoot.toString(), indexFileName).toString()))
        {
            // Document header
            output.format("<!DOCTYPE html>%n");

            // Start of HTML
            output.format("<html lang=\"en\">%n");

            // Start of heading
            output.format("<head>%n");

            // Set charset to UTF-8
            output.format("<meta charset=\"utf-8\">%n");

            // Add author to metadata
            String authorMeta = String.format("<meta name = \"author\" content = \"%s\">%n", authorName);
            output.format(authorMeta);

            // Add title
            String title = String.format("<title>%s</title>%n", websiteName);
            output.format(title);

            // End of heading
            output.format("</head>%n");

            // End of HTML
            output.format("</html>%n");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Unable to create site index at " +
                    Paths.get(siteRoot.toString(), indexFileName));
        }
        System.out.println(FILE_CREATION_HEADER + Paths.get(siteRoot.toString(), indexFileName).toString().replaceFirst(
                currentPath.toString().replace("\\", "\\\\"), "."));
    }

    private void createDirAndDisplayPath(String directoryName)
    {
        // Generate path to new directory
        Path path = Paths.get(siteRoot.toString(), directoryName);

        // Try to make directory
        boolean success = new File(path.toString()).mkdirs();

        // If successful, display path to new dir
        if(success)
        {
            // Display relative path instead of absolute path
            System.out.println(FILE_CREATION_HEADER + path.toString().replaceFirst(
                    currentPath.toString().replace("\\", "\\\\"), "."));
        }
        // Otherwise, display an error message
        else
        {
            System.out.println("Unable to create directory at " + path);
        }
    }
}