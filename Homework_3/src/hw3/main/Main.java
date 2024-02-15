package hw3.main;

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
		
		
	}

}
