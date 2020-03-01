
public class SmartPhone extends Mobile implements Interface1 {

	@Override
	public void call() {
		System.out.println("I'm calling you");		
	}

	@Override
	public void SendMsg() {
		System.out.println("6to ne vdigash kaluf");
		
	}

	@Override
	public void TakeMsg() {
		System.out.println("zaet sam ma ooou");
		
	}
	
	private boolean isTouch=true;
	public void GooglePlay()
	{
		System.out.println("Downloading App");
	}

	public boolean isTouch() {
		return isTouch;
	}

}
