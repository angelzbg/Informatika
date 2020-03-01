package uni.fmi.informatics;

public class MainClass {

	public static void main(String[] args) {
		
		SingleObject object1 = SingleObject.getInstance();
		SingleObject object2 = SingleObject.getInstance();
		
		object1.ShowMessage();
		
		System.out.println(object1.number);
		System.out.println(object2.number);
		
		
		object1.number = 2;
		object2.number = 6;
		
		System.out.println(object1.number);
		System.out.println(object2.number);
		
	}

}
