import java.util.Iterator;

public class LinkedNode<E extends Comparable<E>> implements Iterable<E> { //TODO: complete class definition 

    private Node<E> head;
    
    private class Node<E extends Comparable<E>> {
        
        private E item;      // reference to the item stored at this node
        private Node<E> nextNode;    // reference to the subsequent node in the list
        
        private Node() {
            this(null, null);
        }
        
        private Node(E element, Node<E> next) {
           item = element;   // creates a node with the given item
           nextNode = next;  // and next mode.
        }         
        
        public E getElement( ) { return item; } // Accessor methods
        public Node<E> getNextNode( ) { return nextNode; } 
        public void setElement (E element) { this.item = element; }
        public void setNextNode(Node<E> Node) { this.nextNode = Node; }      
        
        @Override
        public String toString(){
            String nextNode = this.getNextNode() != null ? this.getNextNode().getElement().toString() : "-";
            return "(" + this.getElement().toString() +  " -> " + nextNode + ")";
        }
    }
    
    
    public LinkedNode(){
    }

    public LinkedNode(E headElement) {
        this.head = new Node<E>(headElement, null);
    }
    
    public void insert(E item) {
        if (item == null) throw new NullPointerException();

        Node<E> curr = this.head;
        Node<E> newNode = new Node<>(item, null);

        /* Special case for head node */
        if (this.head == null || this.head.getElement().compareTo(item) >= 0) {
            newNode.setNextNode(head);
            this.head = newNode;
        }
        else {
            while (curr.getNextNode() != null && curr.getNextNode().getElement().compareTo(item) < 0) curr = curr.getNextNode();
            newNode.setNextNode(curr.getNextNode());
            curr.setNextNode(newNode);
        }
    }


        // if (head == null) this.head = new Node<E>(item, null);
        // else if (head.getNextNode() == null){
        //     Node<E> newNode = new Node<E>(item, null);
        //     if (head.getElement().compareTo(item) < 0) {
        //         head.setNextNode(newNode);
        //     }
        //     else{
        //         newNode.setNextNode(this.head);
        //         this.head = newNode;
        //     }
        // }
        // else{
        //     Node<E> curr = head;
        //     while(curr.getNextNode() != null && curr.getNextNode().getElement().compareTo(item) <= 0){
        //         curr = curr.getNextNode();
        //     }
            
        //     Node<E> newNode = new Node<>(item, null);
        //     if(curr == head){
        //         newNode.setNextNode(curr);
        //         this.head = newNode;
        //     }
        //     else{
        //         newNode.setNextNode(curr.getNextNode());
        //     }
        // }
    

    public boolean contains(E item) {
         for(E elem : this){
             if (elem.compareTo(item) == 0)  return true;
             else if (elem.compareTo(item) > 0) return false;
         }
         return false;
    }
    
    public int getLength() {
        int i  = 0; 
        for(E elem : this){
            ++i;
        }
        return i;
    }
    
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> curr = this.head;
        while(curr != null){
            stringBuilder.append(curr.toString()).append(",");
            curr = curr.getNextNode();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedNode<Integer> linkedNode = new LinkedNode<>();
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(5);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(3);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(7);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(13);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(1);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(2);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(27);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(6);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");
        linkedNode.insert(-1);
        System.out.println(linkedNode + "(length: " + linkedNode.getLength() + ")");


        System.out.println("LinkedList contains " + 5 + ": " + linkedNode.contains(5));
        System.out.println("LinkedList contains " + 7 + ": " + linkedNode.contains(7));
        System.out.println("LinkedList contains " + 1 + ": " + linkedNode.contains(1));
        System.out.println("LinkedList contains " + 4 + ": " + linkedNode.contains(4));
        System.out.println("LinkedList contains " + 2 + ": " + linkedNode.contains(2));
        
    }

    @Override
    public LinkedNodeIterator<E> iterator() {
        return new LinkedNodeIterator<E>(head);
    }

    private class LinkedNodeIterator<E extends Comparable<E>> implements Iterator<E>{

        private Node<E> curr;

        private LinkedNodeIterator(Node<E> node){
            this.curr = node;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            Node<E> next = curr;
            curr = curr.getNextNode();
            return next.getElement();
        }
    }
}