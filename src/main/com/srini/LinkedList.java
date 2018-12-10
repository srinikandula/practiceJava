package com.srini;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Node {
    private int value;
    private Node address;
}

public class LinkedList{
    private Node rootNode;

    public void add(int value){
        Node node = new Node();
        node.setValue(value);


        if(rootNode == null){
            rootNode = node;
        } else {
            Node leafNode = rootNode.getAddress();
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
        int counter = 1;
        while(currentNode.getAddress() != null && counter <= index){
            currentNode = currentNode.getAddress();
            counter++;
        }
        return currentNode;
    }

    public void delete(int index){
        if(index == 0){
            rootNode = rootNode.getAddress();
        }
        Node currentNode = rootNode;
        int counter = 1;
        while(currentNode.getAddress() != null && counter <= index){
            currentNode = currentNode.getAddress();
            counter++;
        }
        currentNode.setAddress(currentNode.getAddress().getAddress());
    }
    public void display(){
        Node currentNode = rootNode;
        while(currentNode != null){
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getAddress();
        }
    }

}