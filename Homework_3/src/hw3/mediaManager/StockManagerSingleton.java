package hw3.mediaManager;

import java.util.ArrayList;
import hw3.media.*;

public class StockManagerSingleton {
	
	// Data Section
    private static final StockManagerSingleton INSTANCE = new StockManagerSingleton(); // Only one instance of StockManagerSingleton
    private ArrayList<MediaProduct> inventory;
    private String inventoryFilePath = "../inventory.csv";

    //Private constructor (because its a singleton)
    private StockManagerSingleton() {
        inventory = new ArrayList<>();
    }

    // Public method to get the instance
    public static StockManagerSingleton getInstance() {
        return INSTANCE;
    }
    
    // Assignment object methods
    
    public boolean initializeStock() {
    	
    	return false;
    }


    //Adds given product to end of ArrayList
    //returns flase if an error occurs 
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
    
}
