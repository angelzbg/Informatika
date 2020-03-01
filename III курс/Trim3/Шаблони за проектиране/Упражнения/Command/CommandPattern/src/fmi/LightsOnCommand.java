package fmi;

public class LightsOnCommand implements Command{

	Lights light;
	
	public LightsOnCommand(Lights light){
		this.light = light;
	}
	
	public void execute(){
		this.light.switchOn();
	}
}
