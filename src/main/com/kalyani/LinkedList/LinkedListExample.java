package com.kalyani.LinkedList;

import java.util.Scanner;

public class LinkedListExample{
    public static void main(String[] args){
        LinkedList obj = new LinkedList();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice...");
            System.out.println("1.Add element");
            System.out.println("2.Get list");
            int choice = in.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter a value...");
                    int value = in.nextInt();
                    obj.add(value);
                    break;
                case 2:
                    obj.getList();

            }
        }
    }
}
class Node {
    private int value;
    private Node next;


    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node node) {
        this.next = node;
    }
}

class LinkedList{
//    LinkedList obj1 = new LinkedList();
    private Node rootNode;// head of list
    public void add(int value){
        Node node = new Node();
        node.setValue(value);
        if(rootNode == null){
            rootNode = node;
        }else {
            Node leafNode = rootNode;
            while(leafNode != null){
                leafNode = leafNode.getNext();
            }
            leafNode.setNext(node);
        }
    }

    public void getList() {
        Node n = rootNode;
        while (n != null)
        {
            System.out.print(n.getValue()+" ++++++++======");
            n = n.getNext();
        }
    }
}
