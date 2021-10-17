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

    private Database db;

    public static void main(String[] args)
    {
        Solution44 sol = new Solution44();

        // Read product database
        sol.readJSONFile();

        // Begin search for product
        sol.searchForProduct();

        // Exit
        System.exit(0);
    }

    public void searchForProduct()
    {
        String query;

        // <infinite loop>
        while(true)
        {
            System.out.print("What is the product name? ");
            query = sc.nextLine();

            // Check if query matches any product name in database
            if(db.getProductDatabase().containsKey(query))
            {
                // If so, display product info
                System.out.print(db.getProductDatabase().get(query));
                break;
            }
            else
            {
                // If not, display error message
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
    }

    private void readJSONFile()
    {
        // Attempt to read JSON file
        try(Reader fromFile = Files.newBufferedReader(Paths.get(currentPath.toString(), "exercise44_input.json")))
        {
            // If successful, convert to list of objects
            db = new Gson().fromJson(fromFile,Database.class);
            for(String productName : db.getProductDatabase().keySet())
            {
                System.out.println(db.getProductDatabase().get(productName));
            }
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