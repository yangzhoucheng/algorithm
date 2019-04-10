package ar.mySource;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        int[] arr = {6,3,4,2,7,2,8,5,10,23,11};
        for (int anArr : arr) {
            bst.add(anArr);
        }
        System.out.println(bst.isEmpty());
        System.out.println(bst.getSize());
        System.out.println(bst.contains(5));
        bst.preOrder();
    }
}
