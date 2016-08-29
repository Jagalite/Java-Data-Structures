import java.util.*;

public class AdjacencyMatrix {
    
    public AdjacencyMatrix(int size) {
        graph = new int[size][size];    
    }
    
    public void addEdge(int i, int j, int weight) {
        graph[i][j] = weight;
        graph[j][i] = weight;
    }
    
    public void addDirectedEdge(int i, int j, int weight) {
        graph[i][j] = weight;
    }
    
    public void removeEdge(int i, int j) {
        graph[i][j] = 0;
        graph[j][i] = 0;
    }
    
    public ArrayList getNeighbors(int index) {
        ArrayList neighbors = new ArrayList();
        for(int i = 0; i < graph.length; i++) {
            if(graph[index][i] != 0) {
                neighbors.add(i);
            }
        }
        
        return neighbors;
    }
    
    public boolean hasRelation(int i, int j) {
        if(graph[i][j] == 0) return false;
        
        return true;
    }
    
    int[][] graph;
}