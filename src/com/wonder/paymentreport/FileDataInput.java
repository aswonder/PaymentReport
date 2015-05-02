/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonder.paymentreport;

import com.wonder.paymentreport.interfaces.InputPaymentInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filin
 */
public class FileDataInput implements InputPaymentInterface {

    private List<Person> list = new ArrayList();
    private final String fileSeparator = "\t";
    private String fileName;

    public FileDataInput(String fileName) {
        this.fileName = fileName;
    }

    private List<Person> loadFile(String fileName) {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                throw new FileNotFoundException(file.getName());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), "UTF-8"));
            try {
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split("\t", -1);
                    for (int i = 0; i < fields.length; ++i) {
                        if ("".equals(fields[i])) {
                            fields[i] = null;
                        }
                    }

                    String firstName = fields[0];
                    String lastName = fields[1];
                    String post = fields[2];
                    String job = fields[3];
                    String fixedCost = fields[4];

                    int ante = Integer.parseInt(fields[5]);
                    float index = Float.parseFloat(fields[6]);

                    list.add(new Person(firstName, lastName, post, job, fixedCost, ante, index));
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("File not found!");
        }
        return list;
    }

    @Override
    public List<Person> readData() {
        return loadFile(fileName);
    }

}
