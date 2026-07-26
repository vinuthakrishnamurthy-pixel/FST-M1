package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity8 {
	 public static void main(String[] args) {
	        //Create an ArrayList named myList of type String.
	        List<String> arrList = new ArrayList<String>();
	        //Add 5 names to the ArrayList using add() method.
	        arrList.add("Arya");
	        arrList.add("Srihari");
	        arrList.add("Aprameya");
	        arrList.add("Vinutha");
	        arrList.add("Suraj");
	        //Then print all the names using for loop.
	        for(String name:arrList){
	            System.out.println("Name is :" + name);
	        }
	        //use get() method to retrieve the 3rd name in the ArrayList.
	        System.out.println("3rd name on the list is:" + arrList.get(2));
	        //Use contains() method to check if a name exists in the ArrayList.
	        System.out.println("Does AAS exist in the list:" + arrList.contains("AAS"));
	        //Use size() method to print the number of names in the ArrayList.
	        System.out.println("Array Size is:" + arrList.size());
	        //Use remove() method to remove a name from the list and print the size() of the list again.
	        arrList.remove(4);
	        System.out.println("New Array Size is:" + arrList.size());
	    }

}
