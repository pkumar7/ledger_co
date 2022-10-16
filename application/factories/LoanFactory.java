package application.factories;
import java.math.BigDecimal;
import java.util.UUID;

import domain.entities.Loan;
import domain.entities.borrowers.BorrowerInterface;
import domain.entities.lenders.LenderInterface;

public class LoanFactory {
    public static Loan newLoan(BigDecimal loanAmount, BigDecimal interestRate, Integer timePeriod, 
    BorrowerInterface borrower, LenderInterface lender){
        UUID uuid=UUID.randomUUID();
        Loan loan = new Loan(uuid.toString(), loanAmount, interestRate, timePeriod, 
        borrower, lender);
        return loan;
    }

}
