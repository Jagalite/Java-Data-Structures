public class SkipListNode {
    
    public SkipListNode(Integer data) {
        this.data = data;
    }
    
    Integer data;
    SkipListNode next;
    SkipListNode prev;
    SkipListNode list;
}