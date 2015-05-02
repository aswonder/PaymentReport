package com.wonder.paymentreport;

import com.wonder.paymentreport.interfaces.OutputPaymentInterface;
import java.util.List;

/**
 *
 * @author Andrey S. Divov
 */
public class ConsoleDataOutput implements OutputPaymentInterface {

    @Override
    public void output(List<Person> data) {
        for (Person p : data) {
            System.out.print (p.getFirstName() + " ");
            System.out.print (p.getLastName() + " ");
            System.out.print (p.getPost() + " ");
            System.out.print (p.getJob() + " ");
            System.out.print (p.getFixedCost() + " ");
            System.out.print (p.getAnte() + " ");
            System.out.print (p.getIndex() + " ");
            System.out.println (p.getTotal() + " ");
        }  
    }
}
