package com.company;

abstract class HexadecimalConverter {

    void convertToHexa(String binary, String byteOrdering){
    	String temp = "",result = "";
    	int total = 0;
    	int current; 
    	String resultHexa = "";
    	char tempHexa = ' ';
    	
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
    	if(byteOrdering.equals("l")) {
	    	for(int i = result.length() - 2; i >= 0; i = i - 2) {
	    		tempHexa = result.charAt(i); 
	    		resultHexa = resultHexa + tempHexa;
	    		tempHexa = result.charAt(i+1);
	    		resultHexa = resultHexa + tempHexa;
			}
	    	System.out.println("Little Endian : " + resultHexa);
    	}
    	else if(byteOrdering.equals("b")) {
    		System.out.println("Big Endian : " + result);
    	}
    	
    	
    }
}
