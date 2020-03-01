package fmi;

public class CommandMain {

	public static void main(String[] args) {
		
		RemoteController controller = new RemoteController();
		Lights lights = new Lights();
		
		Command lightsOn = new LightsOnCommand(lights);
		Command lightsOff = new LightsOffCommand(lights);

		controller.setCommand(lightsOn);
		controller.pressButton();
		
		controller.setCommand(lightsOff);
		controller.pressButton();
	}

}
