package fmi;

public class StopState implements State {

	public void executeAction(Context context) {
		System.out.println("Play is in stop state");
		context.setState(this);
	}
	
	public String toString() {
		return "Stop State";
	}

}
