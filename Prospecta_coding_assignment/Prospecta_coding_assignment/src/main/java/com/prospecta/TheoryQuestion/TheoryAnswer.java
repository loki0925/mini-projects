package com.prospecta.TheoryQuestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectReader;
import com.prospecta.controller.Input;

public class TheoryAnswer {

	public static void main(String [] args){
		
		   List<Input> list= ReadCsvFile();

		}
	public static List<Input> ReadCsvFile(){
	  
	try{  
		List<Input> list = new List<Input>;
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("CSVDemo.csv")); 
	    String line;
		while ((line= ( br.readLine()))  != null)    
		{  
		   String[] arr = line.split(","); // use comma as separator 
		   
		   if(arr[0] == "=") {
			   int value;
			  // here we have to iterate over list and implement the formula and get a value
			  //add values to arr 
			   list.add(arr);
		   }
		   else {
			   list.add(arr);
		   }
		}  
		return list;
	}   
	catch (IOException e){  
		    e.printStackTrace();  
		}  
	}
    
}

