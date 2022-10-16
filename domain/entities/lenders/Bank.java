package domain.entities.lenders;


public class Bank implements LenderInterface {

    public String bankId;
    public String bankName;
    public String accountHolderId;

    public Bank(String bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.accountHolderId = bankId;
    }

    @Override
    public String getAccountHolderId() {
        return this.accountHolderId;
    }
    
}
