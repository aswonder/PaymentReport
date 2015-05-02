/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonder.paymentreport.interfaces;

import com.wonder.paymentreport.Person;
import java.util.List;

/**
 *
 * @author filin
 */
public interface OutputPaymentInterface {
    public void output(List<Person> data);
}
