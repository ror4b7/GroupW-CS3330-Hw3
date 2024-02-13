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

}
