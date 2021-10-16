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

class WebsiteGeneratorTest
{
    private final Path currentPath = Paths.get(System.getProperty("user.dir"), "data");

    @Test
    void generateSite() throws FileNotFoundException
    {
        WebsiteGenerator wg = new WebsiteGenerator("siteName",
                "authorName", true, false);

        Path testSiteRoot = Paths.get(currentPath.toString(),  "website", "siteName");

        wg.generateSite();

        // Root dir created?
        assertTrue(Files.exists(testSiteRoot));

        // JS dir created?
        assertTrue(Files.exists(Paths.get(testSiteRoot.toString(), "js")));

        // CSS dir not created?
        assertFalse(Files.exists(Paths.get(testSiteRoot.toString(), "css")));

        // index.html created
        assertTrue(Files.exists(Paths.get(testSiteRoot.toString(), "index.html")));
        Scanner sc = new Scanner(new File(Paths.get(testSiteRoot.toString(), "index.html").toString()));

        String[] expectedIndexHTML = """
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="utf-8">
                <meta name = "author" content = "authorName">
                <title>siteName</title>
                </head>
                </html>
                """.split("\n");

        // Check contents of index.html
        for(String line : expectedIndexHTML)
        {
            assertEquals(line, sc.nextLine());
        }
    }
}