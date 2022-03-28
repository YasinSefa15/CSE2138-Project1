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
        String value = super.convertToHexa(signExtension(unsignedConverter.toBinary()));
    }

    public String signExtension(String value){
        int bits = 8 * sizeOfDataType;
        String sign = value.startsWith("1") ? "1" : "0";
        String extended = "";
        if (value.length() < bits){
            for (int i = 0 ; i < bits - value.length() ; i++){
                extended = extended.concat(sign);
            }
            extended += value;
        }
        return extended;
    }
}
