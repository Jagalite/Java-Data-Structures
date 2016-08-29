import java.util.*;

public class QueueArray<T> {
    
    public QueueArray() {
        queue = new ArrayList<T>();
    }
    
    public void enqueue(T data) {
        queue.add(data);
    }
    
    public T dequeue() {
        return queue.remove(0);
    }
    
    public int getSize() {
        return queue.size();
    }
    
    public boolean hasData(T data) {
        for(int i = 0; i < queue.size(); i++) {
            if(queue.get(i) == data) return true;
        }
        
        return false;
    }
    
    ArrayList<T> queue;
}