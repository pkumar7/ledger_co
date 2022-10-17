package domain.entities;

import java.math.BigDecimal;


public class LoanAccount implements EntityInterface {

    public String accountId;
    public BigDecimal balance;
    public AccountHolderInterface accountHolder;

    // One bank or borrower can have multiple accounts. Each account is linked with one 
    // accountholder.

    public LoanAccount(String accountId, AccountHolderInterface accountHolder) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
