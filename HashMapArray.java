public class HashMapArray {
    
    public HashMapArray(int size) {
        values = new MapNode[size];
        this.size = size;
    }
    
    public void put(Object key, Object value) {
        MapNode node = new MapNode(key, value);
        
        int hashCode = key.hashCode();
        int index = hashCode % size;
        
        if(values[index] == null) {
            values[index] = node;    
        }
        else {
            addNode(values[index], node);
        }
        
        
    }
    
    public Object get(Object key) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        
        return findNode(values[index], key).value;
    }
    
    public boolean containsKey(Object key) {
        
        int hashCode = key.hashCode();
        int index = hashCode % size;
        
        if(findNode(values[index], key) == null) {
            return true;
        }
        
        return false;
    }
    
    public Object delete(Object key) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        
        MapNode target = findNode(values[index], key);
        
        if(target != null) {
            if(target.prev == null) {
                values[index] = target.next;
                values[index].prev = null;
            }
            else if(target.prev != null && target.next != null) {
                target.prev.next = target.next;
                target.next.prev = target.prev;
            }
            else {
                target.prev.next = null;
            }

        }
        return target;
    }
    
    
    private void addNode(MapNode current, MapNode target) {
        if(current.next == null) {
            current.next = target;
            target.prev = current;
        }
        else {
            addNode(current.next, target);
        }
    }
    
    private MapNode findNode(MapNode current, Object target) {
        if(current == null) {
            return null;
        }
        
        if(current.key == target) {
            return current;
        }
        
        return findNode(current.next, target);
    }
    
    
    
    int size;
    MapNode[] values;
}