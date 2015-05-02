package com.wonder.paymentreport;

import com.wonder.paymentreport.interfaces.OutputPaymentInterface;
import java.util.List;

/**
 *
 * @author Andrey S. Divov
 */
public class ConsoleDataOutput implements OutputPaymentInterface {

    public static final String PRINT_SEPARETOR = " ";     
    
    @Override
    public void output(List<Person> data) {
        for (Person p : data) {
            System.out.print (p.getFirstName() + PRINT_SEPARETOR);
            System.out.print (p.getLastName() + PRINT_SEPARETOR);
            System.out.print (p.getPost() + PRINT_SEPARETOR);
            System.out.print (p.getJob() + PRINT_SEPARETOR);
            System.out.print (p.getFixedCost() + PRINT_SEPARETOR);
            System.out.print (p.getAnte() + PRINT_SEPARETOR);
            System.out.print (p.getIndex() + PRINT_SEPARETOR);
            System.out.println (p.getTotal() + PRINT_SEPARETOR);
        }  
    }
}
