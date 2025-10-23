public class FindTarget2 {
    void func(){
        int arr[]  = {7,4,9,6,21,8,11,17};
        int target = 16;
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    System.out.println("found");
                    System.out.println("first element is : -> "+arr[i] + " second element is : -> "+ arr[j]);
                    return;
                }
            }
        }
        System.out.println("not found");
    }
    public static void main(String[] args) {
        FindTarget2 obj = new FindTarget2();
        obj.func();
    }
}
