package com.wonder.paymentreport;

/**
 *
 * @author Andrey S. Divov
 */

public class Person implements Comparable<Person>{

    private String firstName;
    private String lastName;
    private String post;
    private String job;
    private String fixedCost;
    private int ante;
    private float index;
    private float total;
	
    public Person (String firstName, String lastName, String post, 
                   String job, String fixedCost, int ante, float index) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.post = post;
	this.job = job;
	this.fixedCost = fixedCost;
	this.ante = ante;
	this.index = index;
		
        if (fixedCost == "(fixed cost)") {
            this.total = (float)ante;
        } else {
            this.total = ante * index;
        }
    }
        
    public String getFirstName() {
        
	return this.firstName;
    }

    public String getLastName() {
        
	return this.lastName;
    }
	
    public String getPost() {
        
        return this.post;
    }
	
    public String getJob() {
        
        return this.job;
    }
	
    public String getFixedCost() {
        
        return this.fixedCost;
    }
	
    public int getAnte() {	
        
        return this.ante;
    }

    public float getIndex() {	
        
        return this.index;
    }

    public float getTotal() {
        
        return this.total;
    }

	
    @Override
       
    public int compareTo(Person o) {
        
        int result = new Float(this.total).compareTo(new Float(o.total));
        if(result != 0){
            return result;
        }else{
            return this.lastName.compareToIgnoreCase(o.lastName); 
        }
    }
}