package at.mySource.stackAndQueues;

public class LoopQueue<E> implements Queue<E> {
    private E[] array;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        this.array = (E[]) new Object[capacity+1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return array.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if(size+1 == array.length){
            resize(getCapacity()*2);
        }

        array[tail] = e;
        tail = (tail + 1)%array.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("堆中无数据!");
        }

        E element = array[front];
        array[front] = null;
        front = front+1;
        size--;

        if(size == getCapacity()/4 && getCapacity()>1){
            resize(getCapacity()/2);
        }

        return element;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("堆中无数据!");
        }

        return array[front];
    }

    private void resize(int newCapacity){
        E[] newArray = (E[])new Object[newCapacity+1];

        for(int i = 0 ; i < size ; i ++) {
            newArray[i] = array[(i + front) % array.length];
        }

        array = newArray;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % array.length){
            res.append(array[i]);
            if((i + 1) % array.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
