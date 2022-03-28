package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File {

    private Scanner scanner;
    private SignedConverter signedConverter;

    public File(){
        signedConverter = new SignedConverter();
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
         for(int j = 0; j < input.size(); j++) {
             sizeOfDataType = scanner.nextInt();
             if(input.get(j).contains("u")) {
                 System.out.println("unsigned " + input.get(j));
             }
             else if(input.get(j).contains("-")) {
                 signedConverter.changeValues(sizeOfDataType,input.get(j));
                 signedConverter.convert();
                 System.out.println("signed " + input.get(j));
             }
             else if(input.get(j).contains(".")) {
                 System.out.println("floating " + input.get(j));
             }
             else {
                 System.out.println("unsigned " + input.get(j));
             }
        }
    }
}
