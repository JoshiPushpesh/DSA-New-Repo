public class InsertionSort3 {
    public void sort(int arr[]){
        for(int r = 0;r<arr.length;r++){
            for(int c = 0 ;c<r;c++){
                if(arr[r]<arr[c]){
                    int temp = arr[r];
                    arr[r] = arr[c];
                    arr[c] = temp;
                }
            }
        }
        System.out.println("sorted array");
        for(int var : arr){
            System.out.println(var);
        }
    }
    public static void main(String[] args) {
        InsertionSort3 obj = new InsertionSort3();
        int arr[] = {4,2,1,3};
        obj.sort(arr);
    }
}
