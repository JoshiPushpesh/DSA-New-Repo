public class CountEvenOdd1 {
    public static void main(String[] args) {
        int[] arr = {12,3,5,7,8,10,22,33,45,50};
        int even = 0;
        int odd = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]%2==0){
                even++;
            }
            else{
                odd++;
            }
        }
        System.out.println("even nums " + even);
        System.out.println("odd numa " + odd);
    }
}
