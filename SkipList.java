import java.util.*;

public class SkipList {
    
    public SkipList() {
        rand = new Random();
        start = new ArrayList<SkipListNode>();
        end = new ArrayList<SkipListNode>();
        
        SkipListNode startLevel = new SkipListNode(null);
        SkipListNode endLevel = new SkipListNode(null);
                
        startLevel.next = endLevel;
               
        start.add(startLevel);
        end.add(endLevel);
    }

    public void insert(Integer data) {
        
        int level = 1;
        int randomCounter = rand.nextInt(2)-1;
        while(randomCounter != 0) {
            level++;
            randomCounter = rand.nextInt(2)-1;
        }
        
        SkipListNode previous = null;
        for(int i = 0; i < level; i++) {
            SkipListNode node = new SkipListNode(data);
            if(start.size() < i+1) {
                SkipListNode startLevel = new SkipListNode(null);
                SkipListNode endLevel = new SkipListNode(null);
                
                startLevel.next = endLevel;
                startLevel.list = start.get(i-1);
                endLevel.list = end.get(i-1);
                
                start.add(i, startLevel);
                end.add(i, endLevel);
            }    
            
            insert(start.get(i), node);
            node.list = previous;
            previous = node;
        }
    }
    
    public void print() {
        print(start.get(0), new StringBuffer());
    }
    
    public void printAllLevels() {
        for(int i = 0; i < start.size(); i++) {
            print(start.get(i), new StringBuffer());
        }
    }
    
    public void delete(Integer target) {
        SkipListNode found = find(start.get(start.size()-1),target);
        delete(found);
    }
    
    public boolean contains(Integer target) {
        if(find(start.get(start.size()-1),target) == null) {
            return false;   
        }
        
        return true;
    }
    
    private void print(SkipListNode current, StringBuffer buffer) {
        if(current == null) {
            System.out.println(buffer.toString());
        }
        else {
            buffer.append(current.data);
            buffer.append(" -> ");
        
            print(current.next, buffer);            
        }

    }
    
    private void delete(SkipListNode current) {
        if(current != null) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            delete(current.list);   
        }
            
    }
    
    private SkipListNode find(SkipListNode current, Integer target) {
        if(current == null) {
            return null;
        }
        
        if(current.next.data == null) {
            return find(current.list, target);
        }
        
        if(Integer.compare(current.next.data, target) == 0) {
            return current.next;
        }
        
        
        if((target < current.next.data || current.next.data == null) && current.list == null) {
            return null;
        }
        
        if(target < current.next.data) {
            return find(current.list, target);
        }
        
        return find(current.next, target);
    }
    
    
    private void insert(SkipListNode current, SkipListNode target) {
        if(current.next.data == null || target.data <= current.next.data) {
            target.next = current.next;
            target.next.prev = target;
            current.next = target;
            target.prev = current;
        }
        else {
            insert(current.next, target);   
        }
    }
    
    Random rand;
    ArrayList<SkipListNode> start;
    ArrayList<SkipListNode> end;
}