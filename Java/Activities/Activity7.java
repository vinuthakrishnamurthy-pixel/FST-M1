package activites;
//interface BicycleParts
interface BicycleParts{
    public int gears = 0;
    public int speed = 0;
}
//interface BicycleOperations
interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}
//Base Class
class Bicycle implements BicycleParts,BicycleOperations{
    public int gears;
    public int speed;

    //constructor
    public Bicycle(int gears,int speed){
        this.gears = gears;
        this.speed = speed;
    }
        
    public void applyBrake(int decrement){
        speed -= decrement;
        System.out.println("Current Bicycle Speed = " + speed);
        }
    
    public void speedUp(int increment){
        speed += increment;
        System.out.println("Current Bicycle Speed = " + speed);
        }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
        }
}
//Dervied Class
class MountainBike extends Bicycle{
    public int seatHeight;
    //Constructor
    public MountainBike(int gears,int speed,int Height){
        super(gears, speed);
        seatHeight=Height;
    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public String bicycleDesc(){
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }
}
//Driver Class
public class Activity7 {
    public static void main(String args[]) {
        MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
    }
}