
public class StopState implements State{

	
	@Override
	public String toString() {
		return "StopState";
	}

	@Override
	public void doAction(Context c) {
		System.out.println("obekta e v sastoqnie STOP");
		c.setState(this);		
	}

}
