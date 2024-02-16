package hw3.main;

import java.util.ArrayList;

import hw3.media.*;
import hw3.mediaManager.*;

public class Main {
	
	public static void main(String[] args) {	
		
		StockManagerSingleton manager = StockManagerSingleton.getInstance();
		
		manager.initializeStock();
		
		System.out.println("Printing List of Media Products:");
		manager.printListOfMediaProduct(manager.getInventory());
		
		manager.addItem(new CDRecordProduct("Example", 15.00, 2034, Genre.CHILDREN));
		
		System.out.println("\n");
		System.out.println("Adding an Example CD Record to the list:");
		manager.printListOfMediaProduct(manager.getInventory());
		
		manager.saveStock();
		
		System.out.println("\n");
		System.out.println("Updating the price of the first element of the list to 99.99:");
		
		//Sets the price of the first element (CD, Rumours) to 99.99
		manager.updateItemPrice(manager.getInventory().get(0), 99.99);
		
		manager.printListOfMediaProduct(manager.getInventory());
		
		manager.saveStock();
		
		System.out.println("\n");
		System.out.println("Printing list of Tape Records from the inventory:");
		
		//Print Only Tape Records from Inventory
		manager.printListOfTapeRecordProduct(manager.getTapeRecordList(manager.getInventory()));
		
		System.out.println("\n");
		System.out.println("Printing list of CD Records from the inventory:");
		
		//Print only CD Records from Inventory
		manager.printListOfCDRecordProduct(manager.getCDRecordsList(manager.getInventory()));
		
		System.out.println("\n");
		System.out.println("Printing list of Vinyl Records from the inventory:");
		
		//Print only CD Records from Inventory
		manager.printListOfVinylRecordProduct(manager.getVinylRecordList(manager.getInventory()));
		
		
		
		
		
		//manager.printListOfMediaProduct((ArrayList<MediaProduct>)manager.getTapeRecordList(manager.getInventory())
		
		
	}

}
