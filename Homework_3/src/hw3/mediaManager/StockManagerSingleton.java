package hw3.mediaManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import hw3.media.*;

public class StockManagerSingleton {
	
	// Data Section
    private static final StockManagerSingleton INSTANCE = new StockManagerSingleton(); // Only one instance of StockManagerSingleton
    private ArrayList<MediaProduct> inventory;
    private String inventoryFilePath = "inventory.csv";

    //Private constructor (because its a singleton)
    private StockManagerSingleton() {
        inventory = new ArrayList<>();
    }

    // Public method to get the instance
    public static StockManagerSingleton getInstance() {
        return INSTANCE;
    }
    
    // Assignment object methods
    
    public ArrayList<MediaProduct> getInventory() {
		return inventory;
	}
    
	// Initializes the inventory form inventory.csv
    public boolean initializeStock() {
        try {
            // Open the inventory file for reading
            Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
            
            // Read through the file line by line
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                // Split each line into parts based on commas
                String[] tokens = line.split(",");
                
                // The first token indicates the type of media product
                String type = tokens[0];
                
                // Determine the product type and create corresponding product instance
                switch (type) {
                    case "CD":
                        // Create and add a new CDRecordProduct to inventory
                        inventory.add(new CDRecordProduct(tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]), Genre.valueOf(tokens[4].toUpperCase())));
                        break;
                    case "Tape":
                        // Create and add a new TapeRecordProduct to inventory
                        inventory.add(new TapeRecordProduct(tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]), Genre.valueOf(tokens[4].toUpperCase())));
                        break;
                    case "Vinyl":
                        // Create and add a new VinylRecordProduct to inventory
                        inventory.add(new VinylRecordProduct(tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]), Genre.valueOf(tokens[4].toUpperCase())));
                        break;
                }
            }
            
            // Successfully initialized the stock, return true
            fileIn.close();
            return true;
        } catch (FileNotFoundException e) {
            // File not found, return false to indicate failure
            return false;
        }
    }
    
    // this method saves inventory to a file located at inventoryFilePath
    public boolean saveStock() {
        String headerLine = null;

        // Read the header line from the file
        try (Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath))) {
            if (fileIn.hasNextLine()) {
                headerLine = fileIn.nextLine(); // Read the first line (header)
            }
        } catch (FileNotFoundException e) {
            // 
            return false;
        }

        // overwrite the file
        try (PrintWriter fileOut = new PrintWriter(new FileOutputStream(inventoryFilePath, false))) {
            // just makes sure that the header is the first line in the file
        	if (headerLine != null) {
                fileOut.println(headerLine); // Write the original header back
            }

            // Iterate over the inventory and write each item to the file
            for (MediaProduct product : inventory) {
                String line = product.toString();
                fileOut.println(line);
            }
            
            return true; // Successfully saved the stock
        } catch (IOException e) {
            return false; // An error occurred while writing to the file
        }
    }



    //Adds given product to end of ArrayList
    //returns false if an error occurs 
    //FIFO
    public boolean addItem(MediaProduct product)
    {
        try 
        {
            inventory.add(product); 
            
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }



    //removes given product from array 
    //returns false if product not found or an error occurs 
    public boolean removeItem(MediaProduct product)
    {
        try 
        {
        int index = 0; 
        for (MediaProduct item : inventory)
        {
            if (item.equals(product))
            {
                inventory.remove(index); 
                return true; 
            }

            else
            {
                index += 1; 
            }

        }

        return false; 
    }
    catch (Exception e)
    {
        return false; 
    }
    }
    
    //Rachel's method stub 1
    public boolean updateItemPrice(MediaProduct product, double newPrice) {
    	
    	return false;
    	
    }

    //finds all products priced cheaper than the given maxPrice
    //returns said products in a newly-made ArrayList
    public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
        
        //list to be returned
        ArrayList<MediaProduct> itemList = new ArrayList<MediaProduct>();
        
        //cycling through the list
        for(int i=0;i<inventory.size();i++) {
            MediaProduct item = inventory.get(i);
            if(item.getPrice()<maxPrice) {
                itemList.add(item);
            }

        }
        return itemList;
    }

    //prints all media products in the given productList
    public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
        
        for(int i=0;i<productList.size();i++) {
            //printing each individual product
            System.out.println(productList.get(i).toString());
        }
    }

    public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
        //list to hold VinylRecordProduct in the productList
        ArrayList<VinylRecordProduct> vinylList = new ArrayList<VinylRecordProduct>();
        
        //sifting through productList to find vinyl products
        for(MediaProduct product : productList) {
            if(product instanceof VinylRecordProduct) {
                vinylList.add((VinylRecordProduct) product);
            }
            else continue;
        }

        return vinylList;
    } 
    
}
