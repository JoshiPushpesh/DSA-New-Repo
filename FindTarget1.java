class FindTarget1{
    static boolean func(){
     int arr[] = {7,4,9,6,21,8,11,17};
    int target = 16;
    for(int i = 0;i<arr.length;i++){
      for(int j = i+1;j<arr.length;j++){
        if(arr[i]+arr[j]==target)
        {
            return true;
        }
      }
     }
     return false;
    }
   public static void main(String[] args) {
    FindTarget1 obj = new FindTarget1();
    System.out.println(obj.func());
    }
   }


