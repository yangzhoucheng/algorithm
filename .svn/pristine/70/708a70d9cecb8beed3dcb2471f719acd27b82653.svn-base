package at.mysource.array.selecting;

public class Selecting {
    public static int[] selecting(int[] arr){
        int k;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            k = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[k]){
                    k = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
        return arr;
    }
}
