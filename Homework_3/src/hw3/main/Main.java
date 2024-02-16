package hw3.main;

import java.util.ArrayList;

import hw3.media.*;
import hw3.mediaManager.*;

public class Main {
	
	public static void main(String[] args) {	
		
		StockManagerSingleton manager = StockManagerSingleton.getInstance();
		
		manager.initializeStock();
		
		manager.printListOfMediaProduct(manager.getInventory());
		
		manager.addItem(new CDRecordProduct("Example", 15.00, 2034, Genre.CHILDREN));
		
		System.out.println("\n");
		
		manager.printListOfMediaProduct(manager.getInventory());
		
		manager.saveStock();
		
		System.out.println("\n");
		
		//Sets the price of the first element (CD, Rumours) to 99.99
		manager.updateItemPrice(manager.getInventory().get(0), 99.99);
		
		manager.printListOfMediaProduct(manager.getInventory());
		
		manager.saveStock();
		
		System.out.println("\n");
		
		//Print Only Tape Records from Inventory
		manager.printListOfTapeRecordProduct(manager.getTapeRecordList(manager.getInventory()));
		
		System.out.println("\n");
		
		//Print only CD Records from Inventory
		manager.printListOfCDRecordProduct(manager.getCDRecordsList(manager.getInventory()));
		
		
		
		
		
		//manager.printListOfMediaProduct((ArrayList<MediaProduct>)manager.getTapeRecordList(manager.getInventory())
		
		
	}

}
