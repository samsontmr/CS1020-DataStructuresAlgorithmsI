// This program helps staff manage customers'
// orders and decide who should be given a ready dish.

import java.util.*;

// This class represents all orders of customers
class ListOrder {
    
    // Data member
    private int numDishes;
    // All dishes which the restaurant offers
    private String[] dishes;
    // Each dish has a queue of customers who ordered this dish
	// All such queues are put inside an ArrayList called dishQueues
    private ArrayList<Queue<Integer>> dishQueues;
    
    // Constructor
    public ListOrder(int numDishes, Scanner sc) {
        dishes = new String[numDishes];
		for (int i = 0; i < numDishes; i++) {
			dishes[i] = sc.nextLine();
		}
		dishQueues = new ArrayList<Queue<Integer>>();
		for (int i = 0; i < numDishes; i++) {
			dishQueues.add(new LinkedList<Integer>());
		}
    }
    
    // Add new order to the list
    public void addNewOrder(int dishID, int tag) {
    	dishQueues.get(dishID-1).offer(tag); 
    }
    
    // Process food when it is ready
    // Return the customer who currently ordered for the dish
    // if there is no customer order for this dish return -1
    public int processReadyFood(int dishID) {
		if (dishQueues.get(dishID-1).peek() == null) {
			return 0;
		} else {
			int tag = dishQueues.get(dishID-1).poll();
        	return tag; // stub
		}
    }

    // Get dish's name
    public String getDishName(int dishID) {

		return dishes[dishID-1]; // stub
    }

}

public class QuickEat {

    public static void main(String [] args) {
        
        Scanner sc = new Scanner(System.in);
        int numDishes = sc.nextInt();
        sc.nextLine();
        
        // Create the list order of food
        ListOrder listOrder = new ListOrder(numDishes, sc);
        
        int noOfCommands = sc.nextInt();
        sc.nextLine();
        
        // Process commands
		while (noOfCommands-- > 0) {
			String cmd = sc.next();
			if (cmd.equals("Order")) {
				int tag = sc.nextInt();
				int numDish = sc.nextInt();
				while (numDish-- > 0) {
					listOrder.addNewOrder(sc.nextInt(), tag);
				}
			} else if (cmd.equals("Ready")) {
				int dishID = sc.nextInt();
				int serveTo = listOrder.processReadyFood(dishID);
				if (serveTo == 0) {
					System.out.println("Throw away " + listOrder.getDishName(dishID) + ".");
				} else {
					System.out.println(listOrder.getDishName(dishID) + " ready to be served to Tag " + (serveTo) + ".");	
				}
			}
		}

    }
}

