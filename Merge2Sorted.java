public class Merge2Sorted {
    void fun( int arr1[], int arr2[],int arr3[], int n1, int n2){
        int i = 0,j=0,k=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }

          while (i < n1) {
            arr3[k++] = arr1[i++];
        }

        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1,3,10,12,13};
        int arr2[] = {2,4,5,7,9};
        int n1 = arr1.length;
        int n2 = arr2.length;
        int arr3[] = new int[n1 + n2];
        Merge2Sorted obj = new Merge2Sorted();
        obj.fun(arr1, arr2, arr3, n1, n2);

        for(int x : arr3){
            System.out.print(x + " ");
        }
    }
}
