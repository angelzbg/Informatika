package com.fmi.decorator;

public class Rectangle implements IShape {

	@Override
	public void draw() {
		System.out.println("Rectangle");
	}
}
