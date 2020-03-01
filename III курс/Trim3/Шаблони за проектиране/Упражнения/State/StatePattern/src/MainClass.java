
public class MainClass {

	public static void main(String[] args) {
			Context context = new Context();
			
			StartState ss = new StartState();
			ss.doAction(context);
			
			StopState sts = new StopState();
			sts.doAction(context);
	}

}
