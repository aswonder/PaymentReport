package com.wonder.paymentreport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Andrey S. Divov
 */
public class PaymentReport implements InputPaymentData, OutputPaymentData {
    
    private List<Person> list = new ArrayList<Person>();

    PaymentReport(List<Person> data) {
        list = data;
    }
    
    @Override
    public List<Person> getData() {
        return list;
    }

    @Override
    public void setData(List<Person> data) {
        list = data;
    }
    
    public void sort(int sortingType) {
        if (sortingType == 0)
            list.sort(Collections.reverseOrder());
        else if (sortingType == 1)
            Collections.sort(list);
    }
}