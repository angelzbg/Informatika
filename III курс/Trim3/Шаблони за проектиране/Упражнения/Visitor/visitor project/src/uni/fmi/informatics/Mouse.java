package uni.fmi.informatics;

public class Mouse implements ComputerPart {

	   @Override
	   public void accept(ComputerPartVisitor computerPartVisitor) {
	      computerPartVisitor.visit(this);
	   }
	}