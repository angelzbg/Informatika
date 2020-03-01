public class Mortgage //ipoteka
  {
    private Bank _bank = new Bank();
    private Loan _loan = new Loan();
    private Credit _credit = new Credit();
 
    public boolean IsEligible(Customer cust, int amount)
    {
    	System.out.println(cust.Name()+" applies for "+amount+" loan\n");
 
      boolean eligible = true;
 
      // Check creditworthyness of applicant
      if (!_bank.HasSufficientSavings(cust, amount))
      {
        eligible = false;
      }
      else if (!_loan.HasNoBadLoans(cust))
      {
        eligible = false;
      }
      else if (!_credit.HasGoodCredit(cust))
      {
        eligible = false;
      }
 
      return eligible;
    }
  }