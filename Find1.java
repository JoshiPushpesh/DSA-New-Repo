public class Find1 {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int max = arr[0];
        int max2 ;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                if(arr[i]<max){
                    max2 = arr[i];
                    System.out.println("second highest element is " + max2);
                }
            }
        }
    }
}


