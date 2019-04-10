package at.mySource;

@SuppressWarnings("all")
public class LinkedList<E> {

    private Node head;
    private int size;

    private class Node{
        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
           this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    public LinkedList(){
        this.head = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //向指定索引位置添加节点
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界!请检查索引值!");
        }

        Node previousNode = head;
        //从head节点开始检索,当index=0时,不进入循环,即直接在头节点后面添加新节点
        //当index>0时,以此向下检索,直到需要添加位置的前一个位置
        //计算:index计算为从0开始,而起点是头节点的下一个节点,因此index的上一个节点为index-1,
        // 从头节点开始总共需要往前检索index次,才能将previousNode指向index-1位
        for (int i = 0; i < index; i++) {
            previousNode = previousNode.next;
        }

        //逻辑:1.创建新节点,将新节点的next指向前一个节点指向的下一个节点
        //     2.将上一个节点的next指向当前节点
        previousNode.next = new Node(e,previousNode.next);
        size++;
    }

    //在第一个节点位置添加新节点
    public void addFirst(E e){
        add(0,e);
    }

    //在最后一个节点位置添加节点
    public void addLast(E e){
        add(size,e);
    }

    //获取指定索引位置的节点元素
    public E get(int index){
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("索引越界!请检查索引值!");
        }

        Node previousNode = head;
        for (int i = 0; i < index; i++) {
            previousNode = previousNode.next;
        }

        return previousNode.next.e;
    }

    //获取第一个节点位置的值
    public E getFirst(){
        return get(0);
    }

    //获取最后一个节点位置的值
    public E getLast(){
        return get(size-1);
    }

    //修改链表中指定索引位置的节点的值,并返回修改前的值
    public E set(int index,E e){
        if (index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("索引越界!请检查索引值!");
        }

        Node previousNode = head;
        for(int i = 0;i<index;i++){
            previousNode = previousNode.next;
        }

        E element = previousNode.next.e;
        previousNode.next.e = e;
        return element;
    }

    //查询链表中是否包含指定元素
    public boolean contains(E e){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("链表中无元素!");
        }

        Node previousNode;
        if(e == null){
            for(previousNode = head.next;previousNode.next != null;previousNode = previousNode.next){
                if(previousNode.e == null)
                    return true;
            }
        }else {
            for(previousNode = head.next;previousNode.next != null;previousNode = previousNode.next){
                if(e.equals(previousNode.e))
                    return true;
            }
        }

        return false;
    }

    //移除指定索引位置的元素,并返回
    public E remove(int index){
        if (index<0 || index >size-1){
            throw new IndexOutOfBoundsException("索引越界!请检查索引值!");
        }
        Node previousNode = head;
        for (int i = 0; i < index; i++) {
            previousNode = previousNode.next;
        }

        E element = previousNode.next.e;
        Node currentNode = previousNode.next;
        previousNode.next = currentNode.next;
        currentNode.next = null;
        size--;

        return element;
    }

    //移除第一个节点
    public E removeFirst(){
       return remove(0);
    }

    //移除最后一个节点
    public E removeLast(){
        return remove(size-1);
    }

    //从链表中移除指定元素
    public boolean removeElement(E e){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("数组中无元素!");
        }

        int sizeBefore = size;

        Node currentNode;
        Node previousNode = head;
        if(e == null){
           while (previousNode.next != null){
                currentNode = previousNode.next;
                if (currentNode.e == null){
                    previousNode.next = currentNode.next;
                    currentNode.next = null;
                    size--;
                    break;
                }else {
                    previousNode = previousNode.next;
                }
            }
        }else {
            while (previousNode.next != null){
                currentNode = previousNode.next;
                if (e.equals(currentNode.e)){
                    previousNode.next = currentNode.next;
                    currentNode.next = null;
                    size--;
                }else {
                    previousNode = previousNode.next;
                }
            }
        }
        return sizeBefore == size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = head.next;
        while(cur != null){
            res.append(cur.e + "-");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
