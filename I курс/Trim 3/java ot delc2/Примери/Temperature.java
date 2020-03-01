public class Temperature {
	// Convert temperature
	// from Fahrenheit to Centigrade
	
	public static void main(String[] args) {
		double tempFahr; // Fahrenheit
		double tempCels; // Celsius
		System.out.print("Please type the temperature (deg F): ");
		tempFahr = Keyboard.readDouble();
		tempCels = (5.0 * (tempFahr - 32.0)) / 9.0;
		System.out.print(tempFahr);
		System.out.print(" deg F is ");
		System.out.print(tempCels);
		System.out.println(" deg C");
	}
}
