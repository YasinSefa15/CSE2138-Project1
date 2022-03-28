package com.company;

public class UnsignedConverter extends Hexadecimal{
    String byteOrder;
    int sizeOfDataType;
    String value;
    void UnsignedConverter(String byteOrdering,int sizeOfDataType,String value){
        this.byteOrder=byteOrdering;
        this.sizeOfDataType=sizeOfDataType;
        this.value=value;
    }
}
