public class ListNode<T> {
    public ListNode(T data) {
        this.data = data;
    }

    T data;
    ListNode<T> next;
    ListNode<T> prev;
}