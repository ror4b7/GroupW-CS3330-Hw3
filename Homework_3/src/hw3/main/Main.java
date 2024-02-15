package hw3.main;

// import hw3.media.*;
import hw3.mediaManager.*;

public class Main {
	
	public static void main(String[] args) {	
		
		StockManagerSingleton manager = StockManagerSingleton.getInstance();
		
		manager.initializeStock();
		
		manager.printListOfMediaProduct(manager.getInventory());
		
		
	}

}
