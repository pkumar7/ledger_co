package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import application.input.FileInputHandler;

public class Main {
    public static void main(String args[]) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the file path:- ");
        
        try {
            String filePath = consoleReader.readLine();
            FileInputHandler fInputHandler = new FileInputHandler();
            fInputHandler.process(filePath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
