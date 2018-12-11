package com.durgaprasad.collections.LinkedList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

public class LinkedList{
    private Node rootNode;

    public void add(int value) {
        Node node = new Node();
        node.setValue(value);

        if(rootNode == null) {
            rootNode = node;
        } else {
            Node leafNode = rootNode;
            while(leafNode.getAddress() != null){
                leafNode = leafNode.getAddress();
            }
            leafNode.setAddress(node);
        }
    }

    public void getAll() {
        Node n = rootNode;
        while (n != null) {
            System.out.println(n.getValue() + ",");
            n = n.getAddress();
        }
    }

    public void delete(int index) {
        if(index == 0){
            rootNode = rootNode.getAddress();
        }
        Node currentNode = rootNode;
        int counter = 1;
        while(currentNode.getAddress() != null && counter < index){
            currentNode = currentNode.getAddress();
            counter++;
        }
        currentNode.setAddress(currentNode.getAddress().getAddress());
    }

    public void display() {
        Node currentNode = rootNode;
        while(currentNode != null){
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getAddress();
        }
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

    public int getEleIndex(int index) {
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


    public int size() {
        Node r = rootNode;
        int s = 0;
        while (r != null) {
            r = r.getAddress();
            s++;
        }
        return s;
    }

    public boolean isEmpty() {
        Node IE = rootNode;
        if (IE == null) {
            return true;
        }
        return false;
    }

    public void getEleValue(int value) {
        Node n = rootNode;
        int v = 0;
        try {
            while (n != null) {
                n = n.getAddress();
                v = n.getValue();
                if (v == value) {
                    v = value;
                    System.out.println("the given value "+value+"is found");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("the given value "+value+"is Not found");
        }
    }
}