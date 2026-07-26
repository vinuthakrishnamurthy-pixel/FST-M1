package activities;

import java.util.HashSet;

public class Activity9 {
	   public static void main(String[] args) {
		    //Create a HashSet named hs.
		    HashSet<String> hs = new HashSet<String>();
		    //Add 6 objects using add() method to the HashSet.
		    hs.add("Tree");
		    hs.add("Sand");
		    hs.add("Beach");
		    hs.add("Crab");
		    hs.add("Fish");
		    hs.add("Shells");
		    //Then print the size of the HashSet using the size() method.
		    System.out.println("HashSet Size is:" + hs.size());
		    //Remove an element using the remove() method.
		    hs.remove("Crab");
		    //Also try to remove an element that is not present in the Set.
		    if (hs.remove("bike")) {
		        System.out.println("bike removed");
		    } else {
		        System.out.println("bike not present");
		    }
		    //Use the contains() method to check if an item is in the Set or not.
		    System.out.println("Is Fish there in the set?:" + hs.contains("Fish"));
		    //Print the updated set.
		    System.out.println("Updated HashSet: " + hs);
		    }
		    }
