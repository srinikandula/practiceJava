package com.saradhi.LinkedList;

import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;
import java.io.*;

class Node {
    private int value;
    private Node address;


    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Node getAddress() {
        return this.address;
    }

    public void setAddress(Node node) {
        this.address = node;
    }
}

class LinkedList {
    private Node rootNode;// head of list

    public void add(int value) {
        Node node = new Node();
        node.setValue(value);
        if (rootNode == null) {
            rootNode = node;
        } else {
            Node leafNode = rootNode;
            while (leafNode.getAddress() != null) {
                leafNode = leafNode.getAddress();
            }
            leafNode.setAddress(node);
        }
    }

    public void getList() {
        Node n = rootNode;
        while (n != null) {
            System.out.print(n.getValue() + ", \n");
            n = n.getAddress();
        }
    }

    public int size() {
        Node r = rootNode;
        int s = 0;
        while (r != null) {
            r = r.getAddress();
            s++;
        }
        return s;
    }

    public void delete(int index) {
        if (index == 0) {
            rootNode = rootNode.getAddress();
        }
        Node currentNode = rootNode;
        int counter = 1;
        while (currentNode.getAddress() != null && counter < index) {
            currentNode = currentNode.getAddress();
            counter++;
        }
        currentNode.setAddress(currentNode.getAddress().getAddress());
    }

    public int getElementBasedOnIndex(int index) {
        int value = 0;
        if (index == 0) {
            value = rootNode.getValue();
            return value;
        }
        Node currentNode = rootNode;
        int counter = 1;
        while (currentNode.getAddress() != null && counter <= index) {
            currentNode = currentNode.getAddress();
            counter++;
        }

        value = currentNode.getValue();
        return value;
    }

    public void addAt(int index, int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (index == 0) {
            rootNode = rootNode.getAddress();
        }
        Node currentNode = rootNode;
        int counter = 1;
        while (currentNode.getAddress() != null && counter < index) {
            currentNode = currentNode.getAddress();
            counter++;
        }
        newNode.setAddress(currentNode.getAddress());
        currentNode.setAddress(newNode);
    }

    public void getElementBasedOnValue(int value) {
//        int value=0;
        Node r = rootNode;
        int v1 = 0;
      try{
        while (r != null) {
            r = r.getAddress();
            v1 = r.getValue();
            if (v1 == value ) {
                v1=value;
                System.out.println("the given value "+value+"is found");
                break;
            }
        }
        }catch (Exception e){
             System.out.println("the given value "+value+"is Not found");
        }finally {
//          System.out.println("the given value "+value+"is Not found");
      }

    }
    public boolean isEmpty(){
        boolean b;
        if (rootNode!=null){
            b=false;
        }else{
            b=true;
        }
        return  b;
    }
    public void makeEmpty(){
        rootNode=null;
        System.out.println("list becomes empty....");
    }
}


