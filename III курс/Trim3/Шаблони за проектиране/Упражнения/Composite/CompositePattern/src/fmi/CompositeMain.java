package fmi;

public class CompositeMain {

	public static void main(String[] args) {
	
		Developer dev1 = new Developer("Ivan",1500);
		Developer dev2 = new Developer("Peter",2500);
		
		Manager manager1 = new Manager("Daniel",3500);
		manager1.add(dev1);
		manager1.add(dev2);

		Manager manager2 = new Manager("Petkan",5000);
		Developer dev3 = new Developer("Joro", 4000);
		manager2.add(manager1);
		manager2.add(dev3);
		manager2.print();
		
		
	}

}
