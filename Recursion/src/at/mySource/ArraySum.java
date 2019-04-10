package at.mySource;

public class ArraySum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr,int length){
        if(length == arr.length){
            return 0;
        }

        return arr[length] + sum(arr,length + 1);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));
    }
}
