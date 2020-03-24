import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class getLeastNumbers {
    public static int[] getLeastNumbers(int arr[],int k){
        //3.20快排划分
        int length = arr.length;
        int res[] = new int[k];
        if(k == 0){
            return new int[0];
        }
        if(k >= length){
            return arr;
        }
        int index = partition(arr,0,length-1);
        while(index != k-1){
            if(index < k-1){
                index = partition(arr,index+1,length-1);
            }
            else if(index > k-1){
                index = partition(arr,0,index-1);
            }
        }
        for(int i = 0;i < k;i ++){
            res[i] = arr[i];
        }
        return res;
    }
    public static int partition(int arr[],int low,int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(i < j && arr[j] >= pivot){
                j -- ;
            }
            while(i < j && arr[i] <= pivot){
                i ++;
            }
            if(i < j) {
                swap(arr, arr[i], arr[j]);
            }
        }
        arr[low] = arr[i];
        arr[i] = pivot;
        return i;
    }
    public static void swap(int arr[],int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] getLeastNumbersSort(int arr[],int k){
        //Arrays排序
        int length = arr.length;
        int res[] = new int[k];
        if(k == 0){
            return new int[0];
        }
        if(k >= length){
            return arr;
        }
        Arrays.sort(arr);
        for(int i = 0;i < k;i ++){
            res[i] = arr[i];
        }
        return res;
    }

    public static int[] getLeastNumbersPriorityQueue(int arr[],int k){
        int length = arr.length;
        int res[] = new int[k];
        if(k == 0){
            return new int[0];
        }
        if(k >= length){
            return arr;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int i = 0;
        while(i < arr.length){
            if(maxHeap.size() < k){
                maxHeap.add(arr[i]);
            }
            else{
                if(maxHeap.peek() > arr[i]){
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }
            }
            i ++;
        }
        for(int j = 0;j < k;j ++){
            res[j] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,1,6,2,7,3,8};
        getLeastNumbersPriorityQueue(arr,4);
    }




}
