package activities;

import java.util.HashMap;


public class Activity10 {
	public static void main(String[] args) {
        //Create an Map of Colors
        HashMap<Integer,String> hash_map = new HashMap<Integer,String>();
        //Add 5 names to the ArrayList using add() method.
        hash_map.put(1, "Yellow");
        hash_map.put(2, "Blue");
        hash_map.put(3, "Purple");
        hash_map.put(4, "Black");
        hash_map.put(5, "Green");
        //Then print all the colors
        System.out.println("Colour is :" + hash_map);
        //Remove one color using the remove() method.
        hash_map.remove(2);
        System.out.println("Removed Color with above mentioned number");
        System.out.println("New Color List :" + hash_map);
        //Check if the color green exists in the Map using the containsValue() method.
        System.out.println("Does green exist in the list:" + hash_map.containsValue("Green"));
        //Print the size of the Map using the size() method.
        System.out.println("New Array Size is: " + hash_map.size());
               
    }
}

