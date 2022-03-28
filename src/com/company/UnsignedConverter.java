package com.company;

public class UnsignedConverter extends Hexadecimal{
	
	//murat
		
    int sizeOfDataType;
    String value;
    String binaryValue="";
    void changeValues(int sizeOfDataType,String value){
        this.sizeOfDataType=sizeOfDataType;
        this.value=value;
    }

    void convert(){
        extension(toBinary());
    }

    String toBinary(){
        value = value.replace(value.substring(value.length()-1), "");
        int number=Integer.parseInt(value);
        while(number >0){
            if(number%2==0){
                number=number/2;
                binaryValue="0"+binaryValue;
            }else {
                binaryValue="1"+binaryValue;
                number=number/2;
            }
        }
        return binaryValue;
    }
    public String extension(String value){
        int bits = 8 * sizeOfDataType;
        String extended = "";
        if (value.length() < bits){
            for (int i = 0 ; i < bits - value.length() ; i++) {
                extended = extended.concat("0");
            }
            extended += value;
        }
        return extended;
    }
}
