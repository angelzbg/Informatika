
public class MainProgram {

	public static void main(String[] args) {
		// Facade
	      Mortgage mortgage = new Mortgage();
	 
	      // Evaluate mortgage eligibility for customer
	      Customer customer = new Customer("Ann McKinsey");
	      boolean eligible = mortgage.IsEligible(customer, 125000);
	 
	      System.out.println("\n" + customer.Name() +" has been " + (eligible ? "Approved" : "Rejected"));
	 
	      // Wait for user
	     
	}

}
