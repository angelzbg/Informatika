package fmi;

public class StatePatternMain {

	public static void main(String[] args) {
		 
		Context context = new Context();
		
		StartState startState = new StartState();
		startState.executeAction(context);
		
		System.out.println(context.getState());
		
		StopState stopState = new StopState();
		stopState.executeAction(context);
		
		System.out.println(context.getState());
		
	}

}
