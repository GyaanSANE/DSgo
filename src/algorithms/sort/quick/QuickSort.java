package algorithms.sort.quick;

public class QuickSort {


    public static int[] quickSort(int[] arr){
        arr = quickSort(arr, 0, arr.length-1);
        return arr;
    }

    private static int[] quickSort(int[] arr,int start,int end){

        if(start>=end){
            return arr;
        }
        int pivot = arr[end];
        int loc = start;
        for(int i=start;i<end;i++){
            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i] = arr[loc];
                arr[loc] = temp;
                loc++;
            }
        }
        int temp = arr[end];
        arr[end] = arr[loc];
        arr[loc] = temp;

        quickSort(arr, start, loc-1);
        quickSort(arr, loc+1 , end);
        return arr;
    }



public static void printArray(int[] arr){
    for(int i:arr){
        System.out.print(i+" ");
    }
System.out.println();
}
}