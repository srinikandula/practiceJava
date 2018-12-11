package com.durgaprasad.collections.LinkedList;

import java.util.Scanner;

public class test {
    public static void main(String[] args){
        LinkedList obj = new LinkedList();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice...");
            System.out.println("1.Add element");
            System.out.println("2.Get list");
            System.out.println("3.Delete element");
            System.out.println("4.AddAt element");
            System.out.println("5.display");
            System.out.println("6.Size");
            System.out.println("7.IsEmpty");
            System.out.println("8.Get Element Index");
            System.out.println("9.Get Element value");
            int choice = in.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter a value...");
                    int value = in.nextInt();
                    obj.add(value);
                    break;
                case 2:
                    System.out.println("All List");
                    obj.getAll();
                    break;
                case 3:
                    System.out.println("Enter a value : ");
                    int DE = in.nextInt();
                    obj.delete(DE);
                    break;
                case 4:
                    System.out.println("Enter a value : ");
                    int ind = in.nextInt();
                    System.out.println("Enter a value : ");
                    int AddV = in.nextInt();
                    obj.addAt(ind, AddV);
                    break;
                case 5:
//                    System.out.println("Enter a value : ");
//                    int dv = in.nextInt();
////                    obj.display(dv);
                    break;
                case 6:
                    System.out.println(obj.size());
                    break;
                case 7:
                    System.out.println(obj.isEmpty());
                    break;
                case 8:
                    System.out.println("Enter Get Element Index : ");
                    int GEI = in.nextInt();
                    System.out.println(obj.getEleIndex(GEI));
                    break;
                case 9:
                    System.out.println("Enter Get Element Value : ");
                    int GEV = in.nextInt();
                    obj.getEleValue(GEV);
                    break;
            }
        }
    }
}
