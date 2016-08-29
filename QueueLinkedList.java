public class QueueLinkedList<T> {
    
    public void enqueue(T data) {
        ListNode<T> node = new ListNode<T>(data);
        
        if(tail == null && head == null) {
            tail = node;
            head = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        
        size++;
    }
    
    public T dequeue() {
        if(size == 0 || tail == null) return null;
        
        T temp = tail.data;
        
        if(tail.prev == null) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;   
        }
        
        
        size--;
        return temp;
    }
    
    int size;
    ListNode<T> head;
    ListNode<T> tail;
}