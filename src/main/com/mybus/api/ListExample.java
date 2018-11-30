package com.mybus.api;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(43);
        list.add(12);
        list.add(212);
        list.add(23);
        list.add(2143);
        list.add(424);
        list.add(new Integer(2232));
        Iterator<Integer> itr = list.iterator();
        System.out.println("Print all with iterator");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("contains 2?");
        System.out.println(list.contains(23453));
        //list.get(2);

        System.out.println("Print all with for ");
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
