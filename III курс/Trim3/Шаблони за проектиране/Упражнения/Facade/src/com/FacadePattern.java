package com;

// * Facade
// Предоставя уеднаквен интерфейс за редица интерфейси. 
// Фасадата дефинира интерфейс от по-високо ниво, което прави по-лесна употребата на подсистемата

public class FacadePattern {
	   public static void main(String[] args) {
	      ShapeMaker shapeMaker = new ShapeMaker();

	      shapeMaker.drawCircle();
	      shapeMaker.drawRectangle();
	      shapeMaker.drawSquare();		
	   }
}

