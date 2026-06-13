package activites;

public class Activity4 {
    public static void main(String[] args) {
        // Initialize an array with numbers in random order
        int[] array = {64, 34, 25, 12, 22, 11, 90, 88, 45, 50};
        
        // Display the array before sorting
        System.out.println("Array before sorting:");
        displayArray(array);
        
        // Apply insertion sort
        insertionSort(array);
        
        // Display the array after sorting
        System.out.println("Array after sorting:");
        displayArray(array);
    }
    
    //Sorts an array using insertion sort algorithm in ascending order
     
    public static void insertionSort(int[] array) {
        int n = array.length;
        
        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            
            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    
    //Displays the elements of an array
     
    public static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}


