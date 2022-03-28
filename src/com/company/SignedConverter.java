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
        String positiveValue;
        int base;
        String binary = "";
        if (value.contains("-")){
            positiveValue = value.substring(value.indexOf("-")+1);
            base = (int) Math.floor(Math.log(Integer.parseInt(positiveValue)) / Math.log(2));
            base = (int) Math.pow(2, 2 + base) - Integer.parseInt(positiveValue);
            binary = unsignedConverter.toBinary(String.valueOf(base));
            System.out.println(binary);
        }else{
            binary = unsignedConverter.toBinary(value);
            System.out.println(binary);
        }

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
