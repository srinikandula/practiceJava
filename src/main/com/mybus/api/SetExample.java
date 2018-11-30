package com.mybus.api;

import java.util.*;

public class SetExample {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(3);
        set.add(12);
        set.add(22);
        set.add(3);
        set.add(17);
        set.add(3);
        set.add(new Integer(2232));
        Iterator<Integer> itr = set.iterator();
        System.out.println("Print all with iterator");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("contains 2?");
        System.out.println(set.contains(23453));
        //list.get(2);


    }
}
