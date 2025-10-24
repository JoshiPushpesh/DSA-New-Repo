public class FirstLastPosition {
    public static int[]  searchRange(int[] nums, int target){
        int first = findFirst(nums,target);
        int last = findLast(nums,target);
        return new int[]{first,last};
    }
    static int findFirst(int[] nums, int target){
        
    }

 public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    int[] result = searchRange(nums, target);
    System.out.println("first position = " + result[0] + ", last position = " + result[1]);
 }   
}
