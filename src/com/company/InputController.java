package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputController {

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

    public void operate(ArrayList<String> input){
	     Scanner scanner = new Scanner(System.in);
	     int sizeOfDataType;
	     sizeOfDataType = 1;
	     
         for(int j = 0; j < input.size(); j++) {
             if(input.get(j).contains("u")) {
                 unsignedController.updateValues(sizeOfDataType,input.get(j));
                 unsignedController.convert();
             }
             else if(input.get(j).contains(".")) {
                 floatingController.updateValues(sizeOfDataType,input.get(j));
                 System.out.println(input.get(j));
                 floatingController.convert();
                 floatingController.rounding(sizeOfDataType);
                 floatingController.createFloatingPoint(sizeOfDataType);                
             }
             else if(input.get(j).contains("-")) {
                 signedController.updateValues(sizeOfDataType,input.get(j));
                 signedController.convert();
             }
             else {
                 signedController.updateValues(sizeOfDataType,input.get(j));
                 signedController.convert();
             }
        }
    }
}