package harish;

import java.util.*;

public class linkedlistEx {
    public static void main(String []args){
        linkedlist obj = new linkedlist();
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Enter your choice:");
            System.out.println("1.Add elements");
            System.out.println("2.Get elements");
            System.out.println("3.Delete element");
            int choice = in.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter an element into the list:");
                    int key =in.nextInt();
                    obj.add(key);
                    break;
                case 2:
                    obj.getList();
                    break;
                case 3:
                    System.out.println("Enter an element to delete from the list:");
                    key =in.nextInt();
                    obj.deleteKey(key);
                    break;

            }
        }
    }
}
class Nodes{
    private int key;
    private Nodes address;

    public void setKey(int key){
        this.key=key;
    }

    public int getKey(){
        return this.key;
    }

    public Nodes getAddress(){
        return this.address;
    }

    public void setAddress(Nodes node){
        this.address=node;
    }

    public Nodes deleteKey(){
        return this.deleteKey();
    }
}

class linkedlist{
    private Nodes rootNode;
    public void add(int key){
        Nodes node = new Nodes();
        node.setKey(key);
        if (rootNode == null){
            rootNode = node;
        }else {
            Nodes leafNode = rootNode;
            while (leafNode.getAddress()!=null){
                leafNode = leafNode.getAddress();
            }
            leafNode.setAddress(node);
        }
    }

    public void getList() {
        Nodes n = rootNode;
        while (n != null)
        {
            System.out.print(n.getKey()+" ++++++++======");
            n = n.getAddress();
        }

}

    public void deleteKey(int index){
        if(index == 0){
            rootNode = rootNode.getAddress();
        }
        Nodes currentNode = rootNode;
        int counter = 1;
        while(currentNode.getAddress() != null && counter <= index){
            currentNode = currentNode.getAddress();
            counter++;
        }
        currentNode.setAddress(currentNode.getAddress().getAddress());
    }


}
