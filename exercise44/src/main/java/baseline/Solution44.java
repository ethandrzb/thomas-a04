/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Ethan Thomas
 */

package baseline;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

public class Solution44
{
    private static final Scanner sc = new Scanner(System.in);
    private final Path currentPath = Paths.get(System.getProperty("user.dir"), "data");
    private static final String PRODUCT_NOT_FOUND = "<PRODUCT_NOT_FOUND>";

    private Database db;

    public static void main(String[] args)
    {
        Solution44 sol = new Solution44();
        String query;

        // Read product database
        sol.readDatabaseFromJSONFile();

        // Begin search for product
        // <infinite loop>
        while(true)
        {
            System.out.print("What is the product name? ");
            query = sc.nextLine();

            // Check if query matches any product name in database
            if (sol.getProductInfoFromDatabase(query).equals(PRODUCT_NOT_FOUND))
            {
                // If not, display error message
                System.out.println("Sorry, that product was not found in our inventory.");
            }
            else
            {
                // If so, display product info
                System.out.print(sol.getProductInfoFromDatabase(query));
                break;
            }
        }

        // Exit
        System.exit(0);
    }

    public String getProductInfoFromDatabase(String query)
    {
        // Check if query matches any product name in database
        if(db.getProductDatabase().containsKey(query))
        {
            // If so, return product info
            return db.getProductDatabase().get(query).toString();
        }
        else
        {
            // If not, return error code
            return PRODUCT_NOT_FOUND;
        }
    }

    private void readDatabaseFromJSONFile()
    {
        // Attempt to read database from JSON file
        try(Reader fromFile = Files.newBufferedReader(Paths.get(currentPath.toString(), "exercise44_input.json")))
        {
            db = new Gson().fromJson(fromFile,Database.class);
        }
        catch(IOException e)
        {
            // If not, print error message
            System.out.println("Unable to open JSON at " +
                    Paths.get(currentPath.toString(), "exercise44_input.json"));
        }
    }
}

class Database
{
    private final ArrayList<Product> products;

    public Database(List<Product> products)
    {
        this.products = (ArrayList<Product>) products;
    }
    public Map<String, Product> getProductDatabase()
    {
        HashMap<String, Product> productMap = new HashMap<>();

        for(Product p : products)
        {
            productMap.put(p.getName(), p);
        }

        return productMap;
    }
}

class Product
{
    private final String name;
    private final double price;
    private final int quantity;

    public Product(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString()
    {
        return String.format("Name: %s%n" +
                            "Price: %.2f%n" +
                            "Quantity: %d%n", name, price, quantity);
    }

    public String getName()
    {
        return name;
    }
}