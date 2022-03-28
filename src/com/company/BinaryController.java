package com.company;

public class BinaryController {
    String binaryValue;

    public String toBinary(String value){
        this.binaryValue = "";
        if (value.contains("u")){
            value = value.replace(value.substring(value.length()-1), "");
        }
        int number=Integer.parseInt(value);
        if (number == 0 ){
            this.binaryValue = "0";
        }
        while(number >0){
            if(number%2==0){
                number=number/2;
                this.binaryValue="0"+this.binaryValue;
            }else {
                this.binaryValue="1"+this.binaryValue;
                number=number/2;
            }
        }

        return binaryValue;
    }

    public String floatingToBinary(String value){
        this.binaryValue = "";
        Double floating =Double.parseDouble("0." + value);
        int i = 1;
        while (floating > 0){
            if (floating - Math.pow(2,-i) >= 0){
                this.binaryValue += "1";
                floating = floating -  Math.pow(2,-i);
            }else {
                this.binaryValue += "0";
            }
            i++;
        }
        return this.binaryValue;
    }
}
