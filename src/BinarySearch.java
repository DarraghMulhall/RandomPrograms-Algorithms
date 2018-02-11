public class BinarySearch {


    static int binarySearch(int arr[], int left, int right, int x){

        if(left >=0 && left < arr.length && right >=0 && left < arr.length && right>=left){
            int middle = (left+right)/2;

            if(arr[middle] == x){
                return  middle;
            }

            if(arr[middle] > x){
                return  binarySearch(arr, left, middle-1, x);
            }
            else {
                return  binarySearch(arr, middle+1, right, x);
            }
        }
        return  -1;

    }

    public static void main(String args[])
    {
        int arr[] = {2,3,4,10,40};
        int n = arr.length;
        int x = 10;
        int result = BinarySearch.binarySearch(arr,0,n-1,x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " +
                    result);
    }

}
