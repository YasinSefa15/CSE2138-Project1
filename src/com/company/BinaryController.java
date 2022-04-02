package com.company;

public class BinaryController extends HexadecimalConverter{
    String binaryValue;
    int sizeOfDataType;

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

    public String toNegativeBinary(String value){

        String binary = "";
        String positiveValue = value.substring(value.indexOf("-")+1);
        int base = (int) Math.floor(Math.log(Integer.parseInt(positiveValue)) / Math.log(2));
        base = (int) Math.pow(2, 2 + base) - Integer.parseInt(positiveValue);
        //binary = this.signedExtension(toBinary(String.valueOf(base)));
        return toBinary(String.valueOf(base));
    }

    public String floatingToBinary(String value){
        this.binaryValue = "";
        double floating =Double.parseDouble("0." + value);
        int i = 1;
        if (floating == 0){
            return this.binaryValue.concat("0");
        }
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

    public String extension(String value, String sign){
        int bits = 8 * sizeOfDataType;
        String extended = "";
        if (value.length() < bits){
            for (int i = 0 ; i < bits - value.length() ; i++){
                extended = extended.concat(sign);
            }
            extended += value;
        }
        return extended;

    }

    public String unsignedExtension(String value){
        return extension(value,"0");
    }

    public String signedExtension(String value){
        String sign = value.startsWith("1") ? "1" : "0";
        return extension(value,sign);
    }
}
