package fmi;

public class StartState implements State {
	
	public void executeAction(Context context) {
		System.out.println("Player is in start state");
		context.setState(this);
		
	}
	
	public String toString() {
		return "Start State";
	}
}
