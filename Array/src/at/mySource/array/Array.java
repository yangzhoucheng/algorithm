package at.mySource.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class Array<E> {
    private E[] array;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity){
        array = (E[]) new Object[capacity];
        size = 0;
    }

    //获取数组当前元素个数aaa
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return array.length;
    }

    //返回当前数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向指定索引位置添加元素
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引错误!请检查索引值!");
        }

        if(size == array.length){
            resize((int)Math.round(1.5*array.length));
        }

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = e;

        size ++;
    }

    //在末尾添加元素
    public void addLast(E e){
        add(size,e);
    }



    public void add(E e){
        addLast(e);
    }

    //在头部添加一个元素
    public void addFirst(E e){
        add(0,e);
    }

    //获取指定索引位置元素
    public E getElement(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("索引错误!请检查索引值!");
        }

        return array[index];
    }

    //设置指定索引位置元素,并将之前的元素返回
    public E setElement(int index,E e){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("索引错误!请检查索引值!");
        }

        E element = array[index];
        array[index] = e;
        return element;
    }

    //查找数组中指定元素的索引
    public int findFistIndex(E e){
        for (int i = 0;i<size;i++){
            if(e == null){
                if(array[i] ==null){
                    return i;
                }
            }else {
                if(e.equals(array[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    //查找指定元素的所有索引值
    public List<Integer> findAllIndex(E e){
        List<Integer> indexes = new ArrayList<>(size);
        for (int i = 0;i<size;i++){
            if(e == null){
                if(array[i] ==null){
                    indexes.add(i);
                }
            }else {
                if(e.equals(array[i])){
                    indexes.add(i);
                }
            }
        }
        return indexes;
    }

    //返回指定元素在数组中的个数
    public int findCountOfElement(E e){
        int count = 0;

        for (int i =0;i<size;i++){
            if(e == null){
                if(array[i]==null){
                    count++;
                }
            }else {
                if(e.equals(array[i])){
                    count++;
                }
            }
        }

        return count;
    }

    //移除指定索引位置元素并返回
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("索引错误!请检查索引值!");
        }

        E element = array[index];

        if(size <= array.length/4 && array.length >= 1){
            resize(array.length/2);
        }

        System.arraycopy(array,index+1,array,index,size-index-1);
        size--;

        return element;
    }

    //移除头部元素并返回
    public E removeFirst(){
        return remove(0);
    }

    //移除末尾元素并返回
    public E removeLast(){
        return remove(size-1);
    }

    //移除第一个指定元素
    public boolean removeFirstElement(E e){
        int index = findFistIndex(e);

        if(index != -1){
            remove(index);
            return true;
        }

        return false;
    }

    //移除所有指定元素
    public boolean removeAllElement(E e){
        List<Integer> indexes = findAllIndex(e);

        if(indexes.size()>0){
            for (Integer index : indexes) {
                remove(index);
            }
            return true;
        }

        return false;
    }

    //移除所有元素
    public void empty(){
        array = (E[]) new Object[10];
    }

    //调节数组容量
    private void resize(int newCapacity){
        E[] newArray = (E[]) new Object[newCapacity];
        System.arraycopy(array,0,newArray,0,size);

        array = newArray;
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + display() +
                ", size=" + size +
                '}';
    }

    public String display(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size-1; i++) {
            sb.append(array[i]+",");
        }
        sb.append(array[size-1]+"]");
        return sb.toString();
    }
}
