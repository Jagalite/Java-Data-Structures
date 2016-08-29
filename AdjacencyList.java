import java.util.*;

public class AdjacencyList<T> {
    
    public AdjacencyList() {
        vertices = new ArrayList<AdjacencyListNode<T>>();
        graphSize = 0;
    }
    
    public AdjacencyListNode addVertex(T data) {
        AdjacencyListNode vertex = new AdjacencyListNode(data);
        vertices.add(vertex);
        graphSize++;
        return vertex;
    }
    
    public boolean hasVertex(AdjacencyListNode vertex) {
        return vertices.contains(vertex);
    }
    
    public ArrayList<AdjacencyListNode<T>> getAllVertices() {
        return vertices;
    }
    
    public ArrayList<AdjacencyListNode<T>> DFS(AdjacencyListNode start) {
        stack = new StackLinkedList<AdjacencyListNode<T>>();
        stack.push(start);
        
        HashSet visited = new HashSet();
        
        ArrayList<AdjacencyListNode<T>> path = new ArrayList<AdjacencyListNode<T>>();
        
        
        while(stack.size > 0) {
            AdjacencyListNode current = stack.pop();
            path.add(current);    
            visited.add(current);
            
            ArrayList<AdjacencyListNode<T>> neighbors = current.getNeighbors();
            for(AdjacencyListNode neighbor : neighbors) {
                if(!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
        
        return path;
    }
    
    public ArrayList<AdjacencyListNode<T>> BFS(AdjacencyListNode start) {
        queue = new QueueLinkedList<AdjacencyListNode<T>>();
        queue.enqueue(start);
        
        HashSet visited = new HashSet();
        
        ArrayList<AdjacencyListNode<T>> path = new ArrayList<AdjacencyListNode<T>>();
        
        while(queue.size > 0) {
            AdjacencyListNode current = queue.dequeue();
            path.add(current);    
            visited.add(current);
            
            ArrayList<AdjacencyListNode<T>> neighbors = current.getNeighbors();
            for(AdjacencyListNode neighbor : neighbors) {
                if(!visited.contains(neighbor)) {
                    queue.enqueue(neighbor);
                }
            }
            
            
        }
        
        return path;
    }
    
    public ArrayList<AdjacencyListNode<T>> Dijkstra(AdjacencyListNode start, AdjacencyListNode end) {
        PriorityQueue<SearchNode> nextMove = new PriorityQueue(graphSize, new Comparator<SearchNode>() {
            public int compare(SearchNode a, SearchNode b) {
                if(a.value > b.value) return 1;
                if(a.value < b.value) return -1;
                return 0;
            }    
        });
        
        SearchNode init = new SearchNode(start, 1);
        nextMove.add(init);
        
        ArrayList<AdjacencyListNode<T>> path = new ArrayList<AdjacencyListNode<T>>();
        HashSet visited = new HashSet();
        
        while(nextMove.size() > 0) {
            SearchNode<AdjacencyListNode<T>> current = nextMove.poll();
            visited.add(current);
            path.add(current.data);
            
            if(current.data == end) {
                return path;
            }
            
            ArrayList<AdjacencyListNode<T>> neighbors = current.data.getNeighbors();
            for(AdjacencyListNode neighbor : neighbors) {
                if(!visited.contains(neighbor)) {
                    nextMove.add(new SearchNode(neighbor, current.data.getWeight(neighbor)));
                }
            }
        }
        
        return path;
    }
    
    StackLinkedList<AdjacencyListNode<T>> stack;
    QueueLinkedList<AdjacencyListNode<T>> queue;
    ArrayList<AdjacencyListNode<T>> vertices;
    int graphSize;
}

class AdjacencyListNode<T> {
    
    public AdjacencyListNode(T data) {
        this.data = data;
        neighbors = new ArrayList<AdjacencyListNode<T>>();
        weights = new HashMap<AdjacencyListNode, Integer>();
    }
    
    public void addNeighbor(AdjacencyListNode neighbor, int weight) {
        if(!weights.containsKey(neighbor)) {
            neighbors.add(neighbor);   
            weights.put(neighbor, weight);   
        }
    }
    
    public boolean hasNeighbor(AdjacencyListNode neighbor) {
        return neighbors.contains(neighbor);
    }
    
    public ArrayList<AdjacencyListNode<T>> getNeighbors() {
        return neighbors;
    }
    
    public Integer getWeight(AdjacencyListNode neighbor) {
        if(weights.containsKey(neighbor)) {
            return weights.get(neighbor);
        }
        
        return 0;
    }
    
    T data;
    ArrayList<AdjacencyListNode<T>> neighbors;
    HashMap<AdjacencyListNode, Integer> weights;
}

class SearchNode<T> {
    
    public SearchNode(T data, int value) {
        this.data = data;
        this.value = value;
    }
    
    T data;
    int value;
}