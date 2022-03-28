package com.company;

public class FloatingConverter extends Hexadecimal{
    int sizeOfDataType;
    String value;
    UnsignedConverter unsignedConverter;
    int sign;

    public FloatingConverter(UnsignedConverter unsignedConverter){
        this.unsignedConverter = unsignedConverter;
    }

    public void changeValues(int sizeOfDataType, String value){
        this.sizeOfDataType = sizeOfDataType;
        this.value = value;
    }

    public void convert(){
        String decimal = value.substring(0,value.indexOf("."));
        String floating = value.substring(value.indexOf(".") +1);
        String a = unsignedConverter.toBinary(decimal);
        //System.out.println("Decimal Binary : "  + a);
        System.out.println("floating Binary : "  + floatingToBinary(floating));
    }

    public String  floatingToBinary(String value){
        Double floating =Double.parseDouble("0." + value);
        String binary = "";
        int i = 1;
        while (floating > 0){
            if (floating - Math.pow(2,-i) >= 0){
                binary += "1";
                floating = floating -  Math.pow(2,-i);
            }else {
                binary += "0";
            }
            i++;
        }
        return binary;
    }
}
