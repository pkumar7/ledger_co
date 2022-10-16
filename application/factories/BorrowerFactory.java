package application.factories;

import domain.entities.borrowers.BorrowerInterface;
import domain.entities.borrowers.IndividualBorrower;
import java.util.UUID; 

public class BorrowerFactory {
    public static BorrowerInterface newIndividualBorrower(String borrowerName){
        UUID uuid=UUID.randomUUID();
        BorrowerInterface borrower = new IndividualBorrower(
            uuid.toString(), borrowerName);
        return borrower;
    }
    
}
