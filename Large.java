import java.util.Arrays;

public class Large {
    public static void main(String[] args) {
        int[]  arr = {2,3,4,5,6,5};
        Arrays.sort(arr);
        int large = arr[0];
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>large){
                large = arr[i];
            }
            else if(arr[i] != large){
                
            }
        }
    }
}
