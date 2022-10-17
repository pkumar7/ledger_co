package application.factories;
import java.math.BigDecimal;
import java.util.UUID;

import domain.entities.LoanAccount;
import domain.entities.Loan;

public class LoanFactory {
    public static Loan newLoan(BigDecimal loanAmount, BigDecimal interestRate, Integer timePeriod, 
    LoanAccount borrowerAccount, LoanAccount lenderAccount){
        UUID uuid=UUID.randomUUID();

        // creating id from accountholder id as a workaround to make the implementation simpler.
        // Can use uuid and implement search functionality on top of borrower and lender names, as
        // input are only the names.

        String id = borrowerAccount.accountHolder.getAccountHolderId() + 
        lenderAccount.accountHolder.getAccountHolderId();

        Loan loan = new Loan(id, loanAmount, interestRate, timePeriod, 
        borrowerAccount, lenderAccount);
        return loan;
    }
}
