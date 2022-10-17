package application;

import java.io.IOException;

import application.input.FileInputHandler;

public class Main {
    public static void main(String args[]) {
        // BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("Please enter the file path:- ");
        
        try {
            // String filePath = consoleReader.readLine();
            FileInputHandler fInputHandler = new FileInputHandler();
            fInputHandler.process("/Users/pkumar/rand_files/ledger_co/testfile.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
