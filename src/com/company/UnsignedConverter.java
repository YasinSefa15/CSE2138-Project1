package com.company;

public class UnsignedConverter extends BinaryController{
    int sizeOfDataType;
    String value;

    void changeValues(int sizeOfDataType,String value){
        this.sizeOfDataType=sizeOfDataType;
        this.value=value;
    }

    public void convert(){
        unsignedExtension(toBinary(this.value));
    }


    public String unsignedExtension(String value){
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
