package com.company;

public class SignedController extends BinaryController {
    String value;

    public void updateValues(int sizeOfDataType, String value){
        super.sizeOfDataType = sizeOfDataType;
        this.value = value;
    }

    public String convert(String binary){
        String positiveValue;
        int base;
        binary = "";
        if (value.contains("-")){
            binary = signedExtension(super.toNegativeBinary(value));
            return binary;
        }else{
            binary = super.unsignedExtension(super.toBinary(value));
            return binary;
        }
        
    }

}
