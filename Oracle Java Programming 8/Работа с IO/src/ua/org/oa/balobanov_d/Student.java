/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.oa.balobanov_d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DENNNN
 */
public class Student implements Serializable{
    private String fName;
    private String lName;
    
	public Student(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + "]";
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
    
    
}

