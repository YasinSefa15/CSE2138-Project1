package com.company;

abstract class HexadecimalConverter {

    void convertToHexa(String binary){
    	String temp = "",result = "";
    	int total = 0; 
    	
    	for(int i = 1; i<= binary.length(); i++) {
    		
    		temp = temp + binary.charAt(i-1);
    			
    		if(i % 4 == 0) {
    			for(int j = 3, k = 0; j>=0; j--,k++) {
    				int c = temp.charAt(k) - '0';
    				total = total + (int)Math.pow(2, j) * (int)c;
    			}
    			temp = "";
    			if(total == 10)
    				result = result + "A";
    			else if(total == 11)
    				result = result + "B";
    			else if(total == 12)
    				result = result + "C";
    			else if(total == 13)
    				result = result + "D";
    			else if(total == 14)
    				result = result + "E";
    			else if(total == 15)
    				result = result + "F";
    			else
    				result = result + total;
    				
    			total = 0;
    		}
    		
    	}
    	System.out.println("0x" + result);
    }
}
