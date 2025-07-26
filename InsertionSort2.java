
import java.util.*;
public class InsertionSort2 {
    InsertionSort2(){
        int arr[] = new int[5];
        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter element in array");
        for(int i = 0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        //process // sorting
        // row
        for(int r = 1;r<5;r++)
        {
            //column // comp
            for(int c = 0;c<r;c++)
            {
                //condition
                if(arr[r]<arr[c])
                {
                    int temp = arr[r];
                    arr[r] = arr[c];
                    arr[c] = temp;
                    //swap
                }
            }
        }
        System.out.println("sorted array");
            for(int var : arr){
                System.out.println(var);
            }
    }
    public static void main(String[] args) {
        InsertionSort2 obj = new InsertionSort2();
    }
}

