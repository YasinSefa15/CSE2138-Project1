package com.company;

public class SignedConverter extends Hexadecimal {
    int sizeOfDataType;
    String value;

    public void changeValues(int sizeOfDataType, String value){
        this.sizeOfDataType = sizeOfDataType;
        this.value = value;
    }

    public void convert(){
        //Burada dönüştürme işlemi yapılacak
        super.convertToHexa(binary);
    }
}
