
public class MainClass {
	
	public static void main(String[] args) {
		Context context = new Context(new OperatioMultiply());
		System.out.println("umnojenie: " + context.executeStrategy(13, 12));
		
		context = new Context(new OperationSubtract());
		System.out.println("Izvajdane: " + context.executeStrategy(13, 12));
		
		context = new Context(new OperationAdd());
		System.out.println("Sabirane: " + context.executeStrategy(13, 12));
		
	}

}
