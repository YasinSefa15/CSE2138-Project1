package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File {

    private Scanner scanner;
    private SignedConverter signedConverter;
    private UnsignedConverter unsignedConverter;

    public File(){
        unsignedConverter = new UnsignedConverter();
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
        String byteOrder;
        System.out.print("Byte ordering: ");
        sizeOfDataType = scanner.nextInt();
        System.out.print("Floating Point Size: ");
        byteOrder= scanner.next();
         for(int j = 0; j < input.size(); j++) {
             if(input.get(j).contains("u")) {
                 unsignedConverter.changeValues(sizeOfDataType,input.get(j));
                 unsignedConverter.convert();
                 System.out.println("unsigned " + input.get(j));
             }
             else if(input.get(j).contains(".")) {
                 System.out.println("floating " + input.get(j));
             }
             else if(input.get(j).contains("-")) {
                 signedConverter.changeValues(sizeOfDataType,input.get(j));
                 signedConverter.convert();
                 System.out.println("signed " + input.get(j));
             }
             else {
                 System.out.println("unsigned " + input.get(j));
             }
        }
    }
}
