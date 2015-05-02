package com.wonder.paymentreport;

/**
 *
 * @author Andrey S. Divov
 */
import com.wonder.paymentreport.interfaces.InputPaymentInterface;
import com.wonder.paymentreport.interfaces.OutputPaymentInterface;
import java.util.Scanner;

public class Main {

    public static  final String OUTPUT_FILE_NAME = "out.txt";
    
    public static void main(String[] args) {
        
        String fileName;
        
        if (args.length > 0)
            fileName = args[0];
        else {
            System.out.print("Enter filename: ");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.next();
        }
        
        InputPaymentInterface inputFile = new FileDataInput(fileName);
        OutputPaymentInterface console = new ConsoleDataOutput(); 
        
        PaymentReport report = new PaymentReport();
        report.setInputIntreface(inputFile);
        report.setOutputInterface(console);
        report.start(PaymentReport.SortingTypes.ASCENDING);
        
        OutputPaymentInterface outputFile = new FileDataOutput(OUTPUT_FILE_NAME); 
        report.setOutputInterface(outputFile);
        report.start(PaymentReport.SortingTypes.DESCENDING);
    }
}