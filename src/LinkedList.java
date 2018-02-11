public class LinkedList {

    private Node head;

    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public void insertNode(Node newNode){

        if(head == null || newNode.getData() < head.getData()){
            newNode.next = head;
            head = newNode;
        }
        else {
            Node current = head;
            while(current.next != null && current.next.getData() < newNode.getData()){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }


    Node makeNewNode(int data){
        return new Node(data);
    }


    private void printList(){
        Node node = head;
        while(node != null){
            System.out.print(node.getData() + " ");
            node = node.next;
        }
        System.out.println();
    }



    public static void main(String[] args){
        LinkedList list = new LinkedList();

        Node newNode;

        newNode = list.makeNewNode(5);
        list.insertNode(newNode);
        list.printList();
        newNode = list.makeNewNode(10);
        list.insertNode(newNode);
        list.printList();
        newNode = list.makeNewNode(7);
        list.insertNode(newNode);
        list.printList();
        newNode = list.makeNewNode(3);
        list.insertNode(newNode);
        list.printList();
        newNode = list.makeNewNode(1);
        list.insertNode(newNode);
        list.printList();
        newNode = list.makeNewNode(9);
        list.insertNode(newNode);
        list.printList();
    }
}
