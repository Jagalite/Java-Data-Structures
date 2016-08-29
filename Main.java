import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        StackArray stackArray = new StackArray();
        stackArray.push("1");
        stackArray.push("2");
        stackArray.push("3");
        stackArray.push("4");
        stackArray.push("5");
        
        String s = "";
        s += stackArray.pop();
        s += stackArray.pop();
        s += stackArray.pop();
        s += stackArray.pop();
        s += stackArray.pop();
        
        System.out.println("StackArray: " + s);
        
        
        //==========================================
        
        QueueArray queueArray = new QueueArray();
        queueArray.enqueue("1");
        queueArray.enqueue("2");
        queueArray.enqueue("3");
        queueArray.enqueue("4");
        queueArray.enqueue("5");
        
        String q = "";
        q += queueArray.dequeue();
        q += queueArray.dequeue();
        q += queueArray.dequeue();
        q += queueArray.dequeue();
        q += queueArray.dequeue();

        System.out.println("QueueArray: " + q);
        
        //==========================================
        
        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push("1");
        stackLinkedList.push("2");
        stackLinkedList.push("3");
        stackLinkedList.push("4");
        stackLinkedList.push("5");
        
        String x = "";
        x += stackLinkedList.pop();
        x += stackLinkedList.pop();
        x += stackLinkedList.pop();
        x += stackLinkedList.pop();
        x += stackLinkedList.pop();
        
        System.out.println("StackLinkedList: " + x);
        
        
        //==========================================
        
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        queueLinkedList.enqueue("1");
        queueLinkedList.enqueue("2");
        queueLinkedList.enqueue("3");
        queueLinkedList.enqueue("4");
        queueLinkedList.enqueue("5");
        
        String y = "";
        y += queueLinkedList.dequeue();
        y += queueLinkedList.dequeue();
        y += queueLinkedList.dequeue();
        y += queueLinkedList.dequeue();
        y += queueLinkedList.dequeue();

        System.out.println("QueueLinkedList: " + y);
        
        //===========================================
        
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(6);
        
        //bst.delete(6);
        System.out.println(bst.hasNumber(11));
        
        bst.printInOrder();
        
        //===========================================
        
        HashMapArray hma = new HashMapArray(31);
        hma.put("jaga", "tranvo");
        hma.put(1, 2);
        hma.put("FB", "f");
        hma.put("Ea", "e");
        System.out.println("HashMap: " + hma.get("Ea"));
        
        //===========================================
        
        SkipList sl = new SkipList();
        for(int i = 0; i < 100; i++) {
            sl.insert(i);
        }
        
        //sl.delete(5);
        //System.out.println("SkipList: 99 " + sl.contains(99));
        sl.printAllLevels();
        
        //=============================================
        
        AdjacencyList graph = new AdjacencyList();
        
        AdjacencyListNode jon = graph.addVertex("jon");
        
        AdjacencyListNode sally = graph.addVertex("sally");
        AdjacencyListNode how = graph.addVertex("how");
        AdjacencyListNode mike = graph.addVertex("mike");
        
        AdjacencyListNode bob = graph.addVertex("bob");
        AdjacencyListNode kate = graph.addVertex("kate");
        AdjacencyListNode jaga = graph.addVertex("jaga");
        
        how.addNeighbor(jaga, 8);
        
        sally.addNeighbor(how, 1);
        sally.addNeighbor(mike, 1);
        
        bob.addNeighbor(kate, 3);
        bob.addNeighbor(jaga, 1);
        
        jon.addNeighbor(sally, 1);
        jon.addNeighbor(bob, 5);
        
        ArrayList<AdjacencyListNode> pathBFS = graph.BFS(jon);
        String xx = "";
        for(int i = 0; i < pathBFS.size(); i++) {
            xx += (String)pathBFS.get(i).data + " , ";
        }
        System.out.println("BFS: " + xx);
        
        
        ArrayList<AdjacencyListNode> pathDFS = graph.DFS(jon);
        String yy = "";
        for(int i = 0; i < pathDFS.size(); i++) {
            yy += (String)pathDFS.get(i).data + " , ";
        }
        System.out.println("DFS: " + yy);
        
        ArrayList<AdjacencyListNode> pathDijkstra = graph.Dijkstra(jon, jaga);
        String zz = "";
        for(int i = 0; i < pathDijkstra.size(); i++) {
            zz += (String)pathDijkstra.get(i).data + " , ";
        }
        System.out.println("Dijkstra: " + zz);
        
        //=============================================
        
        Trie trie = new Trie();
        trie.addWord("Jaga");
        trie.addWord("Tranvo");
        trie.addWord("Tranppo");
        System.out.println("Trie: " + trie.hasWord("Tranppo"));
        System.out.println("Trie: " + trie.countPreffixes("Tran"));
    }
}
