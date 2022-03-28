package com.company;

public class UnsignedController extends BinaryController{
    private String value;

    void updateValues(int sizeOfDataType,String value){
        super.sizeOfDataType=sizeOfDataType;
        this.value=value;
    }

    public void convert(){
        String binary = super.unsignedExtension(toBinary(this.value));
    }
}
