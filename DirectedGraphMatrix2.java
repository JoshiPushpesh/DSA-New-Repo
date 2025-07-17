public class DirectedGraphMatrix2 {
     private int[][] adjMatrix;
    private int numVertices;

    public DirectedGraphMatrix2(int size){
        numVertices = size;
        adjMatrix = new int [size][size];
    }

    public void adEdge(int i,int j){
        adjMatrix[i][j] = 1;
    }

    public void printMatrix(){
        int var = 65;
        for(int[] row: adjMatrix)
        {
            System.out.print((char)var+" ");
            var++;

            int dar = 65;
            for(int col :  row)
            {
                System.out.print((char)dar+ " ");
                System.out.print(col + " ");
                dar++;
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        DirectedGraphMatrix2 graph = new DirectedGraphMatrix2(5);
        graph.adEdge(0,1);
        graph.adEdge(1,2);
        graph.adEdge(1,3);
        graph.adEdge(2,4);
        graph.adEdge(3,0);
        graph.adEdge(4,3);
        graph.printMatrix();
    }
}
