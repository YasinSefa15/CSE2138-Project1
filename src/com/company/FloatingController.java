package com.company;

public class FloatingController extends BinaryController{
    String value;
    boolean sign;

    public void updateValues(int sizeOfDataType, String value){
        super.sizeOfDataType = sizeOfDataType;
        this.value = value;
    }

    public void convert(){
        if (this.sign = this.value.contains("-")){ //if string value contains sign will be true and if block will be executed
            this.value = this.value.substring(this.value.indexOf("-") + 1); //remove the '-' sign from value
        }

        String decimal = this.value.substring(0,this.value.indexOf("."));
        String floating = this.value.substring(this.value.indexOf(".") +1);

        String floatingBinary = super.floatingToBinary(floating);
        if (sign){ //if the number is negative
            String decimalBinary = super.toNegativeBinary(decimal);
        }
        else{ //when the number is positive this block of code will be executed

        }

    }

}
