package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		int index = 0;
		try {   
			FileInputStream fis = new FileInputStream("input.txt");       
			Scanner input = new Scanner(fis); 
			while(input.hasNextLine()) {  
				list.add(input.nextLine());
			}  
			input.close();     
		}  
		catch(IOException e) {  
			e.printStackTrace();  
		}  
		for(int j = 0; j < list.size(); j++) {
			read(list.get(j));
		}
		
	}
	static void read(String str) {
		if(str.contains("u")) {
			System.out.println("unsigned " + str);
		}
		else if(str.contains("-")) {
			System.out.println("signed " + str);
		}
		else if(str.contains(".")) {
			System.out.println("floating " + str);
		}
		else {
			System.out.println("unsigned " + str);
		}
		
	}
	
	
}


