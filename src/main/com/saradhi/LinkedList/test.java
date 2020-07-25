package com.saradhi.LinkedList;

import java.util.Scanner;

public class test {


        public static void main(String[] args){
            LinkedList obj = new LinkedList();
            Scanner in = new Scanner(System.in);
            while(true){
                System.out.println("Enter your choice...");
                System.out.println("1.Add element");
                System.out.println("2.Get list");
                System.out.println("3.Get Size");
                System.out.println("4.Delete Element");
                System.out.println("5.get Element at index Element");
                System.out.println("6.Add element at perticular index");
                System.out.println("7.seach for an element");
                System.out.println("8.To find list is Empty or not");
                System.out.println("9.make Linkedlist empty");
                int choice = in.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter a value...");
                        int value = in.nextInt();
                        obj.add(value);
                        break;
                    case 2:
                        obj.getList();
                        break;
                    case 3:
                        System.out.println(obj.size());
                        break;
                    case 4:
                        System.out.println("enter Index position");
                        int i=in.nextInt();
                        obj.delete(i);
                        break;
                    case 5:
                        System.out.println("enter Index position to get ");
                        int i1=in.nextInt();
                        System.out.println(obj.getElementBasedOnIndex(i1));
                        break;
                    case 6:
                        System.out.println("enter Index position to get");
                        int i2=in.nextInt();
                        System.out.println("enter Value");
                        int i3=in.nextInt();
                      obj.addAt(i2,i3);
                        break;
                    case 7:
                        System.out.println("enter a value to search in the list");
                        int i4=in.nextInt();
                        obj.getElementBasedOnValue(i4);
                        break;
                    case 8:
                        System.out.println(obj.isEmpty());
                        break;
                    case 9:
                        obj.makeEmpty();
                        break;
            }
        }
    }
}
