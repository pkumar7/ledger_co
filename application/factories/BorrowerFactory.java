package application.factories;

import domain.entities.borrowers.BorrowerInterface;
import domain.entities.borrowers.IndividualBorrower;
import java.util.UUID; 

public class BorrowerFactory {
    public static BorrowerInterface newIndividualBorrower(String borrowerName){
        UUID uuid=UUID.randomUUID();
        // Using name as id for simplicity

        BorrowerInterface borrower = new IndividualBorrower(
            borrowerName, borrowerName);
        return borrower;
    }
    
}
