public class QuickSort {
    
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }
    
    public void quickSort(int[] array, int left, int right) {
        if(left == right) return;
        
        int l = left;
        int r = right;
        int pivot = right;
        
        while(l < r) {
            
            while(l < r && array[l] < array[pivot]) {
                l++;
            }
            
            while(l < r && array[pivot] < array[r]) {
                r--;
            }
            
            if(l < r) {
                swap(array, l, r);
            }
        }
        
        if(r != pivot) {
            swap(array, r, pivot);
        }
        
        quickSort(array, left, r-1);
        quickSort(array, r, right);
    }
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}