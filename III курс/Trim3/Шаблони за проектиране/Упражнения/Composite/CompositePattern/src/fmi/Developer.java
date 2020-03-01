package fmi;

public class Developer implements Employee{
	private String name;
	private double salary;
	
	public Developer(String name, double salary){
		this.name = name;
		this.salary = salary;
	}
	public void add(Employee employee){
		// does nothing as a leaf
	}
	public void remove(Employee employee){
		// does nothing as a leaf
	}
	public Employee getChild(int i){
		// returns nothing as a leaf
		return null;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getSalary(){
		return this.salary;
	}
	public void print(){
		System.out.println("Name: " + getName());
		System.out.println("Salary: " + getSalary());
	}
}
