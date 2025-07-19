import java.util.*;
public class GraphAddMatrix2 {
    private int[][] adjMatrix;
    private int numVertices;

    public GraphAddMatrix2(int size){
        numVertices = size;
        adjMatrix = new int [size][size];
    }

    public void adEdge(int i,int j){
        adjMatrix[i][j] = 1;
    }

    public void printMatrix(){
        for(int[] row: adjMatrix)
        {
            for(int col :  row)
            {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GraphAddMatrix2 graph = new GraphAddMatrix2(3);
        graph.adEdge(0,1);
        graph.adEdge(1,2);
        graph.printMatrix();
    }
}
