package ar.mySource;

public class BinarySearchTree<E extends  Comparable<E>> {
    private class Node {
        private E e;
        private Node left,right;

        private Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private int size;
    private Node root;

    public BinarySearchTree(){}

    public BinarySearchTree(E e){
        root = new Node(e);
        size = 1;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
           root =  add(root,e);
    }

    //作用:向传入的节点添加内容为e的新节点
    private Node add(Node node,E e){
        //判断作用:当传入的节点为空时,即此时已经遍历到了树的叶子节点的子树,
        // 只需要将当前节点编程新创建的节点即可,也就是为之前的叶子节点添加了子树
        if(node == null){
            size++;
            node = new Node(e);
        }

        //判断:当e<传入节点的e时,向左子树继续遍历添加
        if(e.compareTo(node.e)<0)
            //两种情况:当当前节点的左子树为空时,调用add方法,由于传入的node为空,
            //          直接将形参的引用指向新节点并返回,再将node.left指向该引用
            //        当当前节点的左子树不为空时,调用add方法,由于传入的Node不为空,
            //          继续下一次迭代,最终将添加了新节点的节点引用返回,再将Node.left指向该引用
            node.left = add(node.left,e);
        else if(e.compareTo(node.e)>0)
            node.right = add(node.right,e);

        return node;
    }

    public boolean contains(E e){
        if(isEmpty())
            throw new IndexOutOfBoundsException("结构中无元素!");

        return contains(root,e);
    }

    //该方法有两种情况:true和false,因此终止条件有两种
    private boolean contains(Node node,E e){
        //判断:当传入的节点为空时,表明已经遍历完所有符合要求的元素,直接返回false;
        if (node == null)
            return false;

        //判断:当e<node.e时,继续迭代
        if(e.compareTo(node.e)<0)
            return contains(node.left,e);
        //判断:当e>node.e时,继续迭代
        else if(e.compareTo(node.e)>0)
            return contains(node.right,e);

        //当以上条件都不满足时,说明e = node.e,返回true
        return true;
    }

    public void preOrder(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("结构中无元素!");
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
}
