package com.saradhi.api;

import java.io.FileReader;
import java.io.IOException;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        int[] students = new int[5];
        System.out.println("Start...");
        //students[5] = 30;
        try{
            System.out.println("Creating writer");
            FileReader fr = new FileReader("InputFile.txt");

            for (int i = 0; i < 20; i++) {
                // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                 //out.println("Value at: " + i + " = ");
                fr.read();
                System.out.println("writing to file");
            }
            fr.close();
        } catch (RuntimeException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            System.out.println("finally block");
        }

        System.out.println(abs(45));
    }
}
