package com.wonder.paymentreport;

/**
 *
 * @author Andrey S. Divov
 */
import com.wonder.paymentreport.interfaces.InputPaymentInterface;
import com.wonder.paymentreport.interfaces.OutputPaymentInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

public class FileData implements InputPaymentInterface, OutputPaymentInterface {

    private List<Person> list = new ArrayList();
    private final String fileSeparator = "\t";
    private String fileName;
    
    public FileData(String fileName) {
        this.fileName = fileName;
    }
 
    private List<Person> loadFile (String fileName) {
        try {
            File file = new File(fileName);
            
            if (!file.exists()){
                throw new FileNotFoundException(file.getName());
            }
        
            BufferedReader br = new BufferedReader (
                                new InputStreamReader(
                                new FileInputStream( file ), "UTF-8"));
            try {
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split("\t", -1);
                    for (int i = 0; i < fields.length; ++i) {
                        if ("".equals(fields[i])) fields[i] = null;
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
    
    private void saveFile(String fileName) {
        File file = new File(fileName);
        try {
            if(!file.exists()){
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
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> readData() {
        return loadFile(fileName);
    }

    @Override
    public void output(List<Person> data) {
        list = data; 
        saveFile(fileName);
    }
}