import java.util.*;
public class BubbleSort2 
{
        void func()
    {
        //declaration
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        
        //input
        System.out.println("enter elemnts in array");
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }

        //process //sorting

        // pass
        for(int r = 0; r<4; r++)
        {
            //comp
            for(int c = 0;c<4-r; c++)
           {
                //condition
                 if(arr[c]>arr[c+1])
                {
                    // swapping
                    int temp = arr[c];
                    arr[c] = arr[c+1];
                    arr[c+1] = temp;
                }
           } 
        }

        //output
        System.out.println("\n sorted array");
        for(int var : arr)
       {
        System.out.println(" " + var);
       } 
    }
        public static void main(String[] args)
    {
        BubbleSort2 obj = new BubbleSort2();
        obj.func();
    }
}
