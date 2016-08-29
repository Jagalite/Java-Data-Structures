import java.util.*;

public class StackArray<T> {
    
    public StackArray() {
        stack = new ArrayList<T>();
    }
    
    public void push(T data) {
        stack.add(data);
    }
    
    public T pop() {
        return stack.remove(stack.size()-1);
    }
    
    public boolean hasData(T data) {
        for(int i = 0; i < stack.size(); i++) {
            if(stack.get(i) == data) return true;
        }
        
        return false;
    }
    
    public int getSize() {
        return stack.size();
    }
    
    ArrayList<T> stack;
}