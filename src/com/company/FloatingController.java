package com.company;

public class FloatingController extends BinaryController{
    String value;
    boolean sign;
    String beforePoint;
    String mantissa;
    String fraction;
    int exponent;
    int byteOrder = super.sizeOfDataType;
    
    public void updateValues(int sizeOfDataType, String value) {
        super.sizeOfDataType = sizeOfDataType;
        this.value = value;
        this.mantissa = "0";
        this.fraction = "0";
        this.exponent = 0;
    }

    public void convert() {
        if (this.sign = this.value.contains("-")) { //if string value contains sign will be true and if block will be executed
            this.value = this.value.substring(this.value.indexOf("-") + 1); //remove the '-' sign from value
        }

        String decimal = this.value.substring(0, this.value.indexOf("."));
        String floating = this.value.substring(this.value.indexOf(".") + 1);

        String floatingBinary = super.floatingToBinary(floating);
        String decimalBinary;
        if (sign) { //if the number is negative
            decimalBinary = super.toNegativeBinary(decimal);
        } else { //when the number is positive this block of code will be executed
            decimalBinary = super.toBinary(decimal);
        }

        if (decimalBinary.contains("1")) {
            this.exponent = decimalBinary.length() - decimalBinary.indexOf("1") - 1;
            this.mantissa = "1";
            this.fraction = decimalBinary.substring(decimalBinary.indexOf("1") + 1).concat(floatingBinary);
        } else if (floatingBinary.contains("1")) {
            this.exponent = (-1) * (floatingBinary.indexOf("1") + 1);
            this.mantissa = "1";
            if (!floatingBinary.substring(floatingBinary.indexOf("1") + 1).isBlank()) { // if floating part doesn't consist of one index
                this.fraction = floatingBinary.substring(floatingBinary.indexOf("1") + 1);
            }
        }
    }

    public void rounding(int size){
        int index=0;
        int reminder=0;
        String roundControl="";
        switch(size){
            case 1:
                index=4;
                break;
            case 2:
                index=7;
                break;
            case 3:
                index=13;
                break;
            case 4:
                index=19;
                break;
            default:
                System.out.checkError();
        }
        if(fraction.length() == index) {
        	return;
        }
        else if(fraction.length() <= index) {
        	int numberOfZero = index - fraction.length();
        	for(int i = 0; i < numberOfZero; i++) {
        		fraction = fraction + "0";
        	}
        	return;
        }
        String afraction[] = new String[index];
        String arounding[]=  new String[fraction.length()-index];
        for (int i=0;index>i;i++){
          afraction[i]=String.valueOf(fraction.charAt(i));
        }
        for (int i=index,j=0;fraction.length()>i;i++,j++){
            arounding[j]=String.valueOf(fraction.charAt(i));
        }
        for(int i =index;fraction.length()>i;i++){
            roundControl=roundControl+fraction.charAt(i);
        }
        if(arounding[0].equals("0")){
            roundControl ="down";
        }else if (arounding[0].equals("1")){
            for(int i=0;arounding.length>i;i++){
                if (arounding[i].equals("0")){
                    roundControl="equal";
                }else {
                    roundControl="up";
                }
            }
        }
        if(roundControl.equals("up")){
            for (int i=index-1;i>=0;i--){
                if(afraction[i].equals("1")){
                    afraction[i]="0";
                    reminder=1;
                }else {
                    afraction[i]="1";
                    reminder=0;
                    break;
                }
            }
            if(reminder==1){
              if (beforePoint.equals("0")){
                  beforePoint="1";
              }else {
                  beforePoint="10";
              }
            }

        }else if (roundControl.equals("equal")){
            if(afraction[index-1]=="1"){
                afraction[index-1]="0";
                afraction[index-2]="1";
            }
        }

        fraction="";
        for (int i=0;i<index;i++){
            fraction=fraction+afraction[i];
        }
    }


    
    public String createFloatingPoint(int sizeOfDataType) {
    	int exp = 0, expBits= 0;
    	String binaryExp = "",result = "";
    	
    	if(sizeOfDataType == 1)
    		expBits = 3;
    	else if(sizeOfDataType == 2)
    		expBits = 8;
    	else if(sizeOfDataType == 3)
    		expBits = 10;
    	else if(sizeOfDataType == 4)
    		expBits = 12;
    		
    	int bias = (int)(Math.pow(2, expBits - 1) - 1);

        if (exponent < 0 && Math.abs(exponent) >= bias){
        	for(int i = 0; i < expBits; i++) {
        		binaryExp = binaryExp + "0";
        	}
        }else{
            exp = exponent + bias;
        }
    	
    	binaryExp = super.toBinary(Integer.toString(exp));
    	while(binaryExp.length() < expBits) {
    		binaryExp = "0" + binaryExp;
    	}
    	if(sign) {
    		result = "1" + binaryExp.substring(binaryExp.length() - expBits) + fraction;
    	}
    	else {
    		result = "0" + binaryExp.substring(binaryExp.length() - expBits) + fraction;
    	}
    	return result;   		
    }

}