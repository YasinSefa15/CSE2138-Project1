package com.company;

public class SignedConverter extends Hexadecimal {
    int sizeOfDataType;
    String value;
    UnsignedConverter unsignedConverter;


    public SignedConverter(UnsignedConverter unsignedConverter){
        this.unsignedConverter = unsignedConverter;
    }

    public void changeValues(int sizeOfDataType, String value){
        this.sizeOfDataType = sizeOfDataType;
        this.value = value;
    }

    public void convert(){
        //Burada dönüştürme işlemi yapılacak
        String binary=null;
        super.convertToHexa(binary);
    }
}
