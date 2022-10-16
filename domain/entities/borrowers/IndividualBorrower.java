package domain.entities.borrowers;


public class IndividualBorrower implements BorrowerInterface{

    public String borrowerId;
    public String borrowerName;
    public String accountHolderId; 

    public IndividualBorrower(String borrowerId, String borrowerName) {
        this.borrowerId = borrowerId;
        this.borrowerName = borrowerName;
        this.accountHolderId = borrowerId;

    }
    
}
