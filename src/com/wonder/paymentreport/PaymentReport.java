package com.wonder.paymentreport;

import com.wonder.paymentreport.interfaces.InputPaymentInterface;
import com.wonder.paymentreport.interfaces.OutputPaymentInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Andrey S. Divov
 */
public class PaymentReport {
    
    private List<Person> list = new ArrayList<Person>();
    private InputPaymentInterface inputInterface;
    private OutputPaymentInterface outputInterface;
    
    public static final class SortingTypes {
        public static final int DECREASE = 0; 
        public static final int INCREASE = 1;
    };
            
    public void setInputIntreface(InputPaymentInterface inputInterface) {
        this.inputInterface = inputInterface;
    }

    public void setOutputInterface(OutputPaymentInterface outputInterface) {
        this.outputInterface = outputInterface;
    }
    
    private void sort(int sortingType) {
        if (sortingType == PaymentReport.SortingTypes.DECREASE)
            list.sort(Collections.reverseOrder());
        else if (sortingType == PaymentReport.SortingTypes.INCREASE)
            Collections.sort(list);
    }
    
    public void start(int sortingType) {
        list.clear();
        list = inputInterface.readData();
        sort(sortingType);
        outputInterface.output(list);
    }
    
}