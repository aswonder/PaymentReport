/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonder.paymentreport;

import com.wonder.paymentreport.interfaces.OutputPaymentInterface;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filin
 */
public class FileDataOutput implements OutputPaymentInterface {

    private List<Person> list = new ArrayList();
    private final String fileSeparator = "\t";
    private String fileName;

    public FileDataOutput(String fileName) {
        this.fileName = fileName;
    }

    private void saveFile(String fileName) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                for (Person p : list) {
                    out.print(p.getFirstName() + fileSeparator);
                    out.print(p.getLastName() + fileSeparator);
                    out.print(p.getPost() + fileSeparator);
                    out.print(p.getJob() + fileSeparator);
                    out.print(p.getFixedCost() + fileSeparator);
                    out.print(p.getAnte() + fileSeparator);
                    out.print(p.getIndex() + fileSeparator);
                    out.println(p.getTotal() + fileSeparator);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void output(List<Person> data) {
        list = data;
        saveFile(fileName);
    }

}
