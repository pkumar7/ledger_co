package application.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import application.commands.BalanceCommand;
import application.commands.LoanCommand;
import application.commands.PaymentCommand;

public class FileInputHandler implements InputHandler {
    public void process(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            String loanId = null;
            while (line != null) {
                if (line.startsWith("LOAN")) {
                    LoanCommand loanCommand = new LoanCommand(line);
                    loanCommand.addLoan();
                }
                if (line.startsWith("PAYMENT")) {
                    PaymentCommand paymentCommand = new PaymentCommand(line);
                    
                }
                if (line.startsWith("BALANCE")) {
                    BalanceCommand balanceCommand = new BalanceCommand(line);
                    balanceCommand.updateEmi();
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
    }
}
