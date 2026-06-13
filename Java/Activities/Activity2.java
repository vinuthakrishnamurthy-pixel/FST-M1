package activites;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize an array with 6 numbers
        int[] numbers = {10, 77, 10, 54, -11, 10};
        
     // Find the 10's in the array and add them
        int sum = 0;
        for (int num : numbers) {
            if (num == 10) {
                sum += num;
            }
        }
        
        // Check if value is equal to 30
        boolean result = (sum == 30);
        
        // Display the result
        System.out.println("Sum of all 10's: " + sum);
        System.out.println("Is sum equal to 30? " + result);
    
	}

}
