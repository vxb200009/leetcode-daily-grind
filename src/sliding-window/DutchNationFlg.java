
public class DutchNationFlg {

    public void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


    public int[] dutchSort(int[] arr){
        int low=0,high=arr.length-1;
        int mid=0;

        while(mid<=high){
            if(arr[mid]==0)
                swap(arr,low++,mid++);
            else if(arr[mid]==2)
                swap(arr,high--,mid);
            else
                mid++;
        }
        return arr;
    }
    
}
