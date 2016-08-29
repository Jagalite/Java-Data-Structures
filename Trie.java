import java.util.*;

public class Trie {
    
    public Trie() {
        root = new TrieNode(null);
    }
    
    public void addWord(String word) {
        char[] wordArray = word.toCharArray();
        
        TrieNode start = root;
        TrieNode current = root;
        int count = -1;
        while(current != null) {
            count++;
            TrieNode find = current.getNode(wordArray[count]);
            if(find == null) {
                start = current;
                current = null;
            }
            else {
                current = find;
            }
        }
        
        
        insert(start, wordArray, count);
    }
    
    private void insert(TrieNode current, char[] array, int index) {
        if(index != array.length) {
            TrieNode node = new TrieNode(array[index]);
            current.addNode(node);
            insert(node, array, index + 1);
        }
    }
    
    public boolean hasWord(String word) {
        char[] array = word.toCharArray();
        return hasWord(root.getNode(array[0]), array, 0);
    }
    
    private boolean hasWord(TrieNode<Character> current, char[] array, int index) {
        if(index == array.length-1) {
            return true;   
        }
        
        if(current == null) {
            return false;
        }
        
        if(current.data != null && current.data != array[index]) {
            return false;
        }
        
        return hasWord(current.getNode(array[index+1]), array, index + 1);
    }
    
    public int countPreffixes(String prefix) {
        char[] array = prefix.toCharArray();
        TrieNode end = findPrefixEnd(root.getNode(array[0]), array, 0);
        
        if(end == null) {
            return 0;
        }
        
        return end.branches.size();
    }
    
    private TrieNode findPrefixEnd(TrieNode<Character> current, char[] array, int index) {
        if(index == array.length-1) {
            return current;   
        }
        
        if(current == null) {
            return null;
        }
        
        if(current.data != null && current.data != array[index]) {
            return null;
        }
        
        return findPrefixEnd(current.getNode(array[index+1]), array, index + 1);
    }
    
    public void countWords() {
        
    }
    
    TrieNode root;
}

class TrieNode<Character> {
    
    public TrieNode(Character data) {
        this.data = data;
        branches = new ArrayList<TrieNode<Character>>();
    }
    
    public TrieNode getNode(Character data) {
        
        for(int i = 0; i < branches.size(); i++) {
            if(branches.get(i).data == data) {
                return branches.get(i);
            }
        }
        
        return null;
    }
    
    public void addNode(TrieNode node) {
        branches.add(node);
    }
    
    Character data;
    ArrayList<TrieNode<Character>> branches;
}