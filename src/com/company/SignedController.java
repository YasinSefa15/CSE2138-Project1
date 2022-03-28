package com.company;

public class SignedController extends BinaryController {
    String value;

    public void updateValues(int sizeOfDataType, String value){
        super.sizeOfDataType = sizeOfDataType;
        this.value = value;
    }

    public void convert(){
        String positiveValue;
        int base;
        String binary = "";
        if (value.contains("-")){
            binary = super.toNegativeBinary(value);
        }else{
            binary = super.unsignedExtension(super.toBinary(value));
        }
    }

}
