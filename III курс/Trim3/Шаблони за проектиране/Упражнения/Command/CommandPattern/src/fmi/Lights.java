package fmi;

public class Lights {

	private boolean lightsOn;
	
	public void switchOn(){
		System.out.println("Lights are on");
		lightsOn = true;
	}
	public void switchOff(){
		System.out.println("Lights are off");
		lightsOn = false;
	}
}
