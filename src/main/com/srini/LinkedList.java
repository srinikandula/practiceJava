package com.srini;

import lombok.Getter;
import lombok.Setter;


public class LinkedList{
    private Node rootNode;

    public boolean isEmpty(){
        return rootNode == null;
    }
    public void add(int value){
        Node node = new Node();
        node.setValue(value);
        if(rootNode == null){
            rootNode = node;
        } else {
            Node leafNode = rootNode;
            while(leafNode.getAddress() != null){
                leafNode = leafNode.getAddress();
            }
            leafNode.setAddress(node);
        }
    }
    public Node get(int index){
        if(index == 0){
            return rootNode;
        }
        Node currentNode = rootNode;
        int counter = 0;
        while(currentNode.getAddress() != null && counter < index){
            currentNode = currentNode.getAddress();
            counter++;
        }
        if(counter < index){
            return null;
        }
        return currentNode;
    }

    public void delete(int index){
        if(index == 0){
            rootNode = rootNode.getAddress();
        }
        Node currentNode = rootNode;
        int counter = 0;
        Node prevNode = null;
        while(currentNode.getAddress() != null && counter < index){
            prevNode = currentNode;
            currentNode = currentNode.getAddress();
            counter++;
        }
        if(prevNode != null){
            prevNode.setAddress(currentNode.getAddress());
        }
    }


    public void display(){
        Node currentNode = rootNode;
        while(currentNode != null){
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getAddress();
        }
    }

}