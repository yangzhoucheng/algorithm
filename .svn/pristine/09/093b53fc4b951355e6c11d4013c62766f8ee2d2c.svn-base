package at.mysource.array.bobble;

public class Bobble
{
    public static int[] bobble(int[] arr){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for(int j = arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
