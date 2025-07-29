import java.util.*;
public class SortingExample4
{
      List<String> ls;  
      Scanner sc1;   
    SortingExample4()
    {
        ls = new ArrayList<>();

    }
    void insert()
    {
        System.out.println("enter country name ");
        sc1 = new Scanner(System.in);
        String data = sc1.next();

        ls.add(data);
    }
    void delete()
    {
        if(ls.isEmpty()){
            System.out.println("list empty");
        }
        else{
            System.out.println("enter deleted country");
            sc1 = new Scanner(System.in);
            String data = sc1.next();
            if(ls.remove(data))
            {
                System.out.println("data deleted" + data);
            }
            else{
                System.out.println("data not found ");
            }
        }
    }

    void search()
    {
         if(ls.isEmpty()){
            System.out.println(" list empty");
        }
        else{
            System.out.println("enter searching element ---> ");
            sc1 = new Scanner(System.in);
            String data = sc1.next();
            if(ls.contains(data))
            {
                System.out.println("found");
            }
            else{
                System.out.println("not found");
            }

        }
    }
    void traverse()
    {
        if(ls.isEmpty()){
            System.out.println(" list empty");
        }
        else{
            System.out.println(ls);
        }
    }

    void displaySorted()
    {
         if(ls.isEmpty()){
            System.out.println(" list empty");
        }
        else{
            Collections.sort(ls);
            System.out.println(ls);
        }
    }
    public static void main(String[] args)
    {
        SortingExample4 obj = new SortingExample4();
        while(true)
        {
            System.out.println("press 1 to insert");
            System.out.println("press 2 to delete");
            System.out.println("press 3 to search");
            System.out.println("press 4 to traverse");
            System.out.println("press 5 to displaySorted");
            System.out.println("press 6 for exit");

            System.out.println("enter your choice--> ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.insert();
                    break;
            
                case 2:
                    obj.delete();
                    break;
            
                case 3:
                    obj.search();
                    break;
            
                case 4:
                    obj.traverse();
                    break;
            
                case 5:
                    obj.displaySorted();
                    break;
            
                case 6:
                System.exit(0);
                break;
                case 7:
                System.out.println("wrong choice");
                break;
                default:
                    break;
            }
        }
       

    }
}
