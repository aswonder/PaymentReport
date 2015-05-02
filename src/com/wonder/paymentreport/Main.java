package com.wonder.paymentreport;

/**
 *
 * @author Andrey S. Divov
 */
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
        
        InputPaymentData console = new ConsoleData(); 
        OutputPaymentData inputFile = new FileData(fileName);
        
        PaymentReport report = new PaymentReport(inputFile.getData());
        report.sort(0);
        
        console.setData(report.getData());
        
        System.out.print("Enter output filename: ");
        Scanner scanner = new Scanner(System.in);
        fileName = scanner.next();
        
        InputPaymentData outputFile = new FileData(fileName);
        outputFile.setData(report.getData());
    }
}