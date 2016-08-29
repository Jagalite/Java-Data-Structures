public class StackLinkedList<T> {
    
    public void push(T data) {
        size++;
        ListNode<T> node = new ListNode<T>(data);
        
        if(head == null) {
            head = node;
        }
        else {
            node.next = head;
            head = node;
        }
    }
    
    public T pop() {
        if(head == null) return null;
        
        size--;
        T temp = head.data;
        if(head.next == null) {
            head = null;
        }
        else {
            head = head.next;
        }
        return temp;
    }
    
    int size;
    ListNode<T> head;
}