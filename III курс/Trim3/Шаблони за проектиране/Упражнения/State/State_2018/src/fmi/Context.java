package fmi;

public class Context {

	private State state = null;
	
	public Context() {
	
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	

}
