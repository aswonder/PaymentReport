package com.wonder.paymentreport;

/**
 *
 * @author Andrey S. Divov
 */
import com.wonder.paymentreport.paymentdatainterfaces.InputPaymentInterface;
import com.wonder.paymentreport.paymentdatainterfaces.OutputPaymentInterface;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String fileName;
        
        if (args.length > 0)
            fileName = args[0];
        else {
            System.out.print("Enter filename: ");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.next();
        }
        
        InputPaymentInterface inputFile = new FileData(fileName);
        OutputPaymentInterface console = new ConsoleData(); 
        
        PaymentReport report = new PaymentReport();
        report.setInputIntreface(inputFile);
        report.setOutputInterface(console);
        report.start(0);
        
        OutputPaymentInterface outputFile = new FileData("out.txt"); 
        report.setOutputInterface(outputFile);
        report.start(1);
    }
}