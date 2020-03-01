
public class StartState implements State{

	@Override
	public void doAction(Context c) {
		System.out.println("sastoqnieto e START");
		c.setState(this);
		
	}

	@Override
	public String toString() {
		return "Start Sate";
	}

	
}
