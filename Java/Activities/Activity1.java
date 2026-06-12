package activites;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Object
		Car carName = new Car("Black", "Manual", 2014);

		//call methods
		carName.displayCharacteristics() ;
		carName.accelarate();
		carName.brake();
	}

}
