import java.util.Scanner;
class SelectionSort2{
    void func(){
        // declaration..
        int arr[] = new int[5];
        Scanner sc = new Scanner(System.in);
        // input 
        System.out.println("enter element in array");
        for(int i = 0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        // process//sorting
        for(int r = 0;r<4;r++){
            for(int c = r+1;c<5;c++){
                if(arr[r]>arr[c]){
                    // swap
                    int temp = arr[r];
                    arr[r] = arr[c];
                    arr[c] = temp;
                }
            }
        }
        //output
        System.out.println("array elements");
        for(int i =0;i<arr.length;i++){
            System.out.println(" " +arr[i]);
        }
    }
    public static void main(String[] args) {
        SelectionSort2 obj = new SelectionSort2();
        obj.func();
    }
}