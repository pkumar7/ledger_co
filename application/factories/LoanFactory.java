package application.factories;
import java.math.BigDecimal;
import java.util.UUID;

import domain.entities.Account;
import domain.entities.Loan;

public class LoanFactory {
    public static Loan newLoan(BigDecimal loanAmount, BigDecimal interestRate, Integer timePeriod, 
    Account borrower, Account lender){
        UUID uuid=UUID.randomUUID();
        Loan loan = new Loan(uuid.toString(), loanAmount, interestRate, timePeriod, 
        borrower, lender);
        return loan;
    }

}
