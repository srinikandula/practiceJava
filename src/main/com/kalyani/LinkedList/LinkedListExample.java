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
            System.out.println("3.Delete element from list");
            System.out.println("4.Insert");
            System.out.println("5.Get value at index");
            System.out.println("6.Get size of linked list");
            System.out.println("7.check if empty or not");
            System.out.println("8.clear list");
            int choice = in.nextInt();
            int index = 0;
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
                    System.out.println("Enter the position");
                    int pos = in.nextInt();
                    obj.deleteAtIndex(pos);
                    break;
                case 4:
                    System.out.println("Enter a value...");
                    int val = in.nextInt();
                    System.out.println("Enter the position");
                     index = in.nextInt();
                    obj.insertAt(val,index);
                    break;
                case 5:
                    System.out.println("Enter the position");
                    int indexVal = in.nextInt();
                    System.out.println("The value is....."+obj.getValueAtIndex(indexVal));
                    break;
                case 6:
                    System.out.println("Size of list is..."+obj.findSize());
                    break;
                case 7:
                    System.out.println(obj.isEmpty());
                    break;
                case 8:
                    System.out.println(obj.clear());
                    break;
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
    private Node rootNode;// head of list
    public void add(int value){
        Node node = new Node();
        node.setValue(value);
        if(rootNode == null){
            rootNode = node;
        }else {
            Node leafNode = rootNode;
            while(leafNode.getNext() != null){
                leafNode = leafNode.getNext();
            }
            leafNode.setNext(node);
        }
    }

    public void getList() {
        Node n = rootNode;
        while (n != null)
        {
            System.out.print(n.getValue()+" ");
            n = n.getNext();
        }
    }

    public void insertAt(int val, int index) {
        int counter = 1;// 12 13 14 15 16 17.......2 18
        Node currentNode = rootNode;
        while(counter < index){
            currentNode = currentNode.getNext();
            counter++;
        }
        Node newNode = new Node();
        newNode.setValue(val);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
    }

    public int getValueAtIndex(int indexVal) {
        int index = 0,value=0;
        Node currentNode = rootNode;
        while (currentNode != null){
            if(index == indexVal){
                value =  currentNode.getValue();
                break;
            }
            currentNode = currentNode.getNext();
            index ++;
        }
        return value;
    }
    public void deleteAtIndex(int index) {
        int counter = 1;
       if(index == 0){
           rootNode = rootNode.getNext();// 12  13  14  15  16  17
       }else{
           Node currentNode = rootNode;
           while(counter < index){
               currentNode = currentNode.getNext();
               counter++;
           }
           currentNode.setNext(currentNode.getNext().getNext());
       }
    }

    public int findSize() {
        int counter = 0;
        Node n = rootNode;
        while(n != null){
            counter++;
            n = n.getNext();
        }
        return counter;
    }

    public boolean isEmpty() {
       if(rootNode == null)
           return true;
       return false;
    }
    // make root node null bcoz linked list is represented by root node
    public boolean clear() {
        if(rootNode != null){
            rootNode = null;
            return true;
        }
        return false;
    }
}
