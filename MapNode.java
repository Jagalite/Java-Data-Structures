public class MapNode {
    
    public MapNode(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    
    Object key;
    Object value;
    MapNode next;
    MapNode prev;
}