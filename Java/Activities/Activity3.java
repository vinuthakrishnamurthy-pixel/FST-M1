package activites;

enum Device {
	LIGHT,
	THERMOSTAT
}

public class Activity3 {
	public static String adjustDevice(Device device, int value) {
		String status = switch (device) {
		case null -> "Invalid device type";
		case Device d when d.equals(Device.THERMOSTAT) && value > 40 -> "[THERMOSTAT] Warning: Temperature too high!";
		case THERMOSTAT -> "[THERMOSTAT] Temp is set to " + value;
		case LIGHT -> "[LIGHT] Adjusting brightness to " + value + "%";
		default -> "Unknown device";
		};
		
		return status;
	}
	
	public static void main(String[] args) {
		System.out.println(adjustDevice(Device.THERMOSTAT, 50));
	}
}
