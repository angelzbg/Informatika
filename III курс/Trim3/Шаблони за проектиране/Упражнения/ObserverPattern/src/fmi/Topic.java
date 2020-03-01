package fmi;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject{
	private List<Observer> observers;
	private String message;
	
	public Topic(){
		this.observers = new ArrayList<Observer>();
	}
	public void register(Observer obj){
		this.observers.add(obj);
	}
	public void unregister(Observer obj){
		this.observers.remove(obj);
	}
	
	public void notifyObservers(){
		for(Observer obj: this.observers){
			obj.update();
		}
	}
	
	public String getUpdate(){
		return this.message;
	}
	
	public void postMessage(String msg){
		this.message = msg;
		System.out.println("Topic changed to: " + msg);
		notifyObservers();
	}
	
}
