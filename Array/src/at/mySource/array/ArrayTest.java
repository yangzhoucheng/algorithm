package at.mySource.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(10);

        System.out.println(cal(-1));
        /*array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);

        System.out.println(array);
        System.out.println(array.getCapacity());

        array.add(10);
        array.add(11);
        System.out.println(array);
        System.out.println(array.getCapacity());

        array.add(0,-1);
        System.out.println(array);
        System.out.println(array.getCapacity());

        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        System.out.println(array);
        System.out.println(array.getCapacity());

        array.removeFirst();
        array.removeFirst();
        array.add(1);
        System.out.println(array);
        System.out.println(array.getCapacity());*/
    }

    public static int cal(int x){
        if (x == 0)
            return 0;
        else
            return x + cal(x-1);
    }
}
