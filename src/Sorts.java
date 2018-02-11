public class Sorts {

    static void insertionSort(int[] arr){
        int temp = 0;
        int count = 0;
        for(int i=1; i<arr.length; i++){
            int j = i;
            while(j>0 && arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    j--;
            }
        }
    }


    private static void merge(int[] arr, int leftIndex, int middle, int rightIndex){
        int size1 = middle - leftIndex + 1;
        int size2 = rightIndex - middle;

        int left[] = new int[size1];
        int right[] = new int[size2];

        for(int i=0; i<size1; i++){
            left[i] = arr[leftIndex + i];
        }
        for(int i=0; i<size2; i++){
            System.out.println(middle);
            right[i] = arr[middle + 1 + i];
        }

        int i = 0, j = 0;

        int index = leftIndex;

        while(i < size1 && j < size2){
            if(left[i] <= right[j]){
                arr[index] = left[i++];
            }
            else {
                arr[index] = right[j++];
            }
            index++;
        }

        while(i < size1){
            arr[index++] = left[i++];
        }

        while(j < size2){
            arr[index++] = right[j++];
        }


    }


    static void mergeSort(int arr[], int leftIndex, int rightIndex){

        if(leftIndex < rightIndex) {
            int middle = (leftIndex + rightIndex)/2;
            mergeSort(arr, leftIndex, middle);
            mergeSort(arr, middle + 1, rightIndex);

            merge(arr, leftIndex, middle, rightIndex);
        }
    }


    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6};

       //Sorts.insertionSort(arr);
       // Sorts.sort(arr);
        Sorts.mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }

}
