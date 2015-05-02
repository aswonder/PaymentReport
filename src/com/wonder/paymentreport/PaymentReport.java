package com.wonder.paymentreport;

/**
 *
 * @author Andrey S. Divov
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PaymentReport {

    public static void main(String[] args) {
        
        String fileName;
        
        if (args.length > 0)
            fileName = args[0];
        else {
            System.out.print("Enter filename: ");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.next();
        }
        
        PaymentData inputFile = new FileData(fileName);
        List list = new ArrayList<Person>(inputFile.getData());
        
        list.sort(Collections.reverseOrder());

        PaymentData console = new ConsoleData(); // Хотя вывод можно сделать через статический метод
                                                 // для демонстрации интерфейса здесь создается экземпляр
        
        PaymentData outputFile = new FileData("out.txt");
        outputFile.setData(list);
        console.setData(list);
    }
}