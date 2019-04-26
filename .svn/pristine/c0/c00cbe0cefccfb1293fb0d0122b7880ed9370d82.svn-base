package at.mySource;

public class LinkedListQueue<E> implements Queue<E>{

    private class Node{
        E e;
        Node next;

        Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        private Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if(tail == null){
            tail = node;
            head = tail;
        }else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("队列中无元素!");

        Node headNode = head;
        head = head.next;
        headNode.next = null;
        if(head == null)
            tail = null;
        size--;
        return headNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("队列中无元素!");

        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
