package domain.entities;

import java.math.BigDecimal;


public class Account implements EntityInterface {

    public String accountId;
    public BigDecimal balance;
    public AccountHolder accountHolder;

    // One bank or borrower can have multiple accounts. Each account is linked with one 
    // accountholder.

    public Account(String accountId, AccountHolder accountHolder) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.setBalance(BigDecimal.valueOf(0));
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
