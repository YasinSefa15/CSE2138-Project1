package com.company;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputController extends HexadecimalConverter{

    private final SignedController signedController;
    private final UnsignedController unsignedController;
    private final FloatingController floatingController;

    public InputController(){
        unsignedController = new UnsignedController();
        floatingController = new FloatingController();
        signedController = new SignedController();
    }

    public ArrayList<String> read(){
        ArrayList<String> list = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream("input.txt");
            Scanner input = new Scanner(fis);
            while(input.hasNextLine()) {
                list.add(input.nextLine());
            }
            input.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void fileWrite(String hexa) {
    	
    	try
    	{
    	    String filename= "output.txt";
    	    FileWriter fw = new FileWriter(filename,true); 
    	    fw.write(hexa + "\n");
    	    fw.close();
    	}
    	catch(IOException ioe)
    	{
    	    System.err.println("IOException: " + ioe.getMessage());
    	}
    }
    
    

    public void operate(ArrayList<String> input){
	     Scanner scanner = new Scanner(System.in);
	     System.out.print("Byte ordering : ");
	     String byteOrdering = scanner.nextLine();
	     System.out.print("Floating point size : ");
	     int sizeOfDataType = scanner.nextInt();
	     
         for(int j = 0; j < input.size(); j++) {
             if(input.get(j).contains("u")) {
                 unsignedController.updateValues(sizeOfDataType,input.get(j));
                 fileWrite(super.convertToHexa(unsignedController.convert(input.get(j)), byteOrdering));
             }
             else if(input.get(j).contains(".")) {
                 floatingController.updateValues(sizeOfDataType,input.get(j));
                 floatingController.convert();
                 floatingController.rounding(sizeOfDataType);
                 fileWrite(super.convertToHexa(floatingController.createFloatingPoint(sizeOfDataType), byteOrdering));
             }
             else if(input.get(j).contains("-")) {
                 signedController.updateValues(sizeOfDataType,input.get(j));
                 fileWrite(super.convertToHexa(signedController.convert(input.get(j)), byteOrdering));
             }
             else {
                 signedController.updateValues(sizeOfDataType,input.get(j));
                 fileWrite(super.convertToHexa(signedController.convert(input.get(j)), byteOrdering));
             }
        }
    }
}