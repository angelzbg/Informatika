import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GSMTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		SmartPhone phone1=new SmartPhone();
		phone1.setModel("Galaxy S3");
		SmartPhone phone2=new SmartPhone();
		phone2.setModel("S6");
		phone1.battery.setTime(50);
		
		System.out.print("Enter price: ");
		phone1.setPrice(input.nextDouble());
		
	List<SmartPhone> phones=new ArrayList<SmartPhone>();
	
	phones.add(phone1);
	phones.add(phone2);
	
	for(SmartPhone phone : phones)
	{
		System.out.println(phone.getModel());
		phone.SendMsg();
		phone.TakeMsg();
	}
	}

}
