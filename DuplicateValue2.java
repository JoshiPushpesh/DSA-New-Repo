import java.util.Scanner;
public class DuplicateValue2 {
  DuplicateValue2(){
    Scanner sc = new Scanner(System.in);
    int arr[] = new int[5];
    System.out.println("enter input in array ");
    for(int i = 0;i<5;i++){
        arr[i] = sc.nextInt();
    }
    System.out.println("enter checking elemnts = ");
    int check = sc.nextInt();
    int dupCount = 0;
    for( int i = 0;i<5;i++){
      if(arr[i]==check){
        dupCount++;
      }
    }
        System.out.println("found no of times " + dupCount );
        if(dupCount>1){
          System.out.println("duplicate value ");
        }
        else{
          System.out.println("not found ! ");
        }

  }
    public static void main(String[] args) {
        DuplicateValue2 obj  = new DuplicateValue2();
        // obj.DuplicateValue();
    }
}
