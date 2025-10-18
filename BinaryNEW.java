public class BinaryNEW {
 public static void main(String[] args) {
    int[]  arr = {5, 10, 15, 20, 25, 30, 35};
    int target = 25;
    int left = 0;
    int right = arr.length-1;
    boolean found = false;
    while(left<=right){
        int mid = left+(right-left)/2;
        if(arr[mid]==target){
            System.out.println("element found " + arr[mid]);
            found = true;
            break;
        }else if(arr[mid]<target){
            left = mid+1;
        }else{
            right = mid-1;
        }
    }
    if(!found){
    System.out.println("not found");
    }
 }   
}
