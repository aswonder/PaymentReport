/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonder.paymentreport;

import java.util.List;

/**
 *
 * @author Andrey S. Divov
 */
public interface PaymentData {
    public List<Person> getData();
    public void setData(List<Person> data);
}
