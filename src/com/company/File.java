package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File {

    private Scanner scanner;
    private SignedConverter signedConverter;
    private UnsignedConverter unsignedConverter;
    private FloatingConverter floatingConverter;

    public File(){
        unsignedConverter = new UnsignedConverter();
        floatingConverter = new FloatingConverter(unsignedConverter);
        signedConverter = new SignedConverter(unsignedConverter);
    }

    public ArrayList<String> Read(){
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

    public void Operation(ArrayList<String> input){
        scanner = new Scanner(System.in);
        int sizeOfDataType;
         sizeOfDataType = 2;
         for(int j = 0; j < input.size(); j++) {
             if(input.get(j).contains("u")) {

             }
             else if(input.get(j).contains(".")) {
                 floatingConverter.changeValues(sizeOfDataType,input.get(j));
                 floatingConverter.convert();
             }
             else if(input.get(j).contains("-")) {
                 signedConverter.changeValues(sizeOfDataType,input.get(j));
                 signedConverter.convert();
             }

             else {
                 signedConverter.changeValues(sizeOfDataType,input.get(j));
                 signedConverter.convert();
             }
        }
    }
}
