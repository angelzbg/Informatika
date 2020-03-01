package fmi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager implements Employee{

	private String name;
	private double salary;
	List<Employee> employees = new ArrayList<Employee>();
	
	public Manager(String name, double salary){
		this.name = name;
		this.salary = salary;
	}
	
	public void add(Employee employee){
		employees.add(employee);
	}
	public void remove(Employee employee){
		employees.remove(employee);
	}
	public Employee getChild(int i){
		return employees.get(i);
	}
	public String getName(){
		return this.name;
	}
	public double getSalary(){
		return this.salary;
	}
	
	public void print(){
	System.out.println("Manager Name:" + getName());
	System.out.println("Manager Salary:" + getSalary());
		
	Iterator<Employee> employeeIterator = employees.iterator();
	while(employeeIterator.hasNext()){
		Employee employee = employeeIterator.next();
		employee.print();
	}
	}
}
