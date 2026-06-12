package activites;

public class Car {
	//Variables
	String color;
	String transmission;
	int make;
	int tyres = 4;
	int doors = 4;
	
	//constructor
	public Car (String color, String transmission,int make) {
		this.color=color;
		this.transmission=transmission;
		this.make=make;
	}
		
	//methods
		public void displayCharacteristics() {
			System.out.println("Car color is: " + this.color);
			System.out.println("Transmission type is: " + this.transmission);
			System.out.println("Make is: " + this.make);
			}
		public void accelarate() {
			System.out.println("Accelaration Status: Car is moving forward.");
		}
		public void brake() {
			System.out.println("Brake Status: Car has stopped.");
		}			
		
	}

