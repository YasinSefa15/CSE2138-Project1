package com.company;

public class UnsignedController extends BinaryController{
    private String value;

    void updateValues(int sizeOfDataType,String value){
        super.sizeOfDataType=sizeOfDataType;
        this.value=value;
    }

    public String convert(String binary){
        binary = super.unsignedExtension(toBinary(this.value));
        return binary;
    }
}
