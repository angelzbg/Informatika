package fmi;

public class LightsOffCommand implements Command{

	Lights light;
	
	public LightsOffCommand(Lights light){
		this.light = light;
	}
	
	public void execute(){
		this.light.switchOff();
	}
}
