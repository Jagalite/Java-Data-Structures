import java.util.*;

public class HeapSort {
    public void heapSort(int[] array) {
        PriorityQueue<Integer> queue = new PriorityQueue(array.length, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if(a > b) return 1;
                if(a < b) return -1;
                return 0;
            }
        });
        
        for(int i : array) {
            queue.add(i);
        }
        
        for(int i = 0; i < array.length; i++) {
            array[i] = queue.poll();
        }
    }
}