import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
    Node (int item){
    this.data = item;
    this.left = null;
    this.right = null;
}
}


public class TreeImplementation2
    {  
   static  class Node
    {
        int data;
        Node left;
        Node right;
      
        Node(int item)
        {
            this.data= item;
            this.left=null;
            this.right=null;

        }
    }
      int sum = 0;
      int count = 0;
       Node root;
    TreeImplementation2()
    {
       root =null;
    }

    void inorder(Node root)
    {
        if(this.root==null)
        {
            System.out.println("Tree Empty");
        }

        else if(root==null)
        {
            return ;
        }

        else
        {
            inorder(root.left);
            System.out.print(" "+root.data);
            inorder(root.right);
        }

    }

    void preorder(Node root)
    {
         if(this.root==null)
        {
            System.out.println("Tree Empty");
        }

        else if(root==null)
        {
            return ;
        }

        else
        {
            System.out.println(""+root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root)
    {
         if(this.root==null)
        {
            System.out.println("Tree Empty");
        }

        else if(root==null)
        {
            return ;
        }

        else
        {
            postorder(root.left); 
            postorder(root.right);
             System.out.println(""+root.data);
        }
    }

    void search()
    {
        if(this.root==null)
        {
            System.out.println("Tree Empty");
        }       
    else 
    {
        System.out.println("Enter searching element");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        int count = 0;
        Node current = root;

        if (current.data == key)
         {
            count++;
        }

        if (current.left != null && current.left.data == key)
         {
            count++;
        }

        if (current.right != null && current.right.data == key)
         {
            count++;
        }

        if (count > 0)
         {
            System.out.println("Element found ");
        }
        
        else
         {
            System.out.println("Element not found");
        }
    }
     
    }

    void evenOdd(Node root)
    {
        if(this.root == null){
            System.out.println("tree empty0");
        }
    }

    void treeElementSum(Node root){
        if(this.root == null){
            System.out.println("tree empty");
        }
        else if(root == null){
            return;
        }
        else{
            sum = sum + root.data;
            treeElementSum(root.left);
            treeElementSum(root.right);
        }
        System.out.println(sum);
    }

    void nodeCount(Node root)
    {
      if(this.root == null){
            System.out.println("tree empty");
        }
        else if(root == null){
            return;
        }
        else{
            count++;
            nodeCount(root.left);
            nodeCount(root.right);
        }   
        System.out.println("no of element " + count);
    }

    void checkPrime(Node root)
    {
         if(this.root == null){
            System.out.println("tree empty");
        }
        else if(root == null){
            return;
        }
        else{
            System.out.println(" " + root.data);
            int var = root.data;
            int Pcount = 0;

            for(int i = 2;i<var;i++){
                if(var%i==0){
                    Pcount++;
                }
            }
            if(Pcount == 0){
                System.out.println("prime");
            }
            else{
                System.out.println("not prime");
            }

            checkPrime(root.left);
            checkPrime(root.right);
        }
    }
        
    public static void main(String args[])
    {
        TreeImplementation2 obj = new TreeImplementation2();

        obj.root=new Node(50);
        obj.root.left = new Node(25);
        obj.root.right = new Node(75);

        obj.root.left.left=new Node(7);
        obj.root.left.right=new Node(31);

        obj.root.right.left = new Node(60);
        obj.root.right.right = new Node(85);


        Scanner sc = new Scanner(System.in);
        while (true)
         {
            System.out.println("Press 1 for Inorder Traversal:");
             System.out.println("Press 2 for Preorder Traversal:");
              System.out.println("Press 3 for Postorder Traversal:") ;
               System.out.println("Press 4 for EXIT:");
                System.out.println("Press 5 to search the element:") ;
                System.out.println("Press 6 to evenodd the element:") ;
                System.out.println("Press 7 to sum the element:") ;
                System.out.println("Press 8 to node count:") ;
                System.out.println("Press 9 to checkPrime or not:") ;
               
             System.out.println("Enter your choice");
             int choice = sc.nextInt();  

             switch(choice)
             {
                case 1:
                obj.inorder(obj.root);
                break;

                case 2:
                obj.preorder(obj.root);
                break;

                case 3:
                 obj.postorder(obj.root);
                break;

                case 4:
                System.exit(0);
                break;

                case 5:
                obj.search();
                break;

                case 6:
                obj.evenOdd(obj.root);
                break;

                case 7:
                obj.treeElementSum(obj.root);
                break;

                case 8:
                obj.nodeCount(obj.root);
                break;

                case 9:
                obj.checkPrime(obj.root);
                break;

                default:
                System.out.println("Invalid choice");
             }
            
        }
    }
}


