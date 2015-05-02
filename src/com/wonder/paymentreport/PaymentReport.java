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
      
    public enum SortingTypes {
        ASCENDING, DESCENDING
    }
    
    public void setInputIntreface(InputPaymentInterface inputInterface) {
        this.inputInterface = inputInterface;
    }

    public void setOutputInterface(OutputPaymentInterface outputInterface) {
        this.outputInterface = outputInterface;
    }

    private void sort(SortingTypes sortingType) {
        if (sortingType == SortingTypes.DESCENDING)
            list.sort(Collections.reverseOrder());
        else if (sortingType == SortingTypes.ASCENDING)
            Collections.sort(list);
    }
    public void start(SortingTypes sorting) {
        list.clear();
        list = inputInterface.readData();
        sort(sorting);
        outputInterface.output(list);
    }
}