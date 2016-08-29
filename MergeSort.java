import java.util.*;

public class MergeSort {
    
    public void mergeSort(int[] array) {
        int count = 0;
        for(int i : mergeSortRecur(array)) {
            array[count++] = i;
        }
    }
    
    private int[] mergeSortRecur(int[] array) {
        if(array.length == 1) {
            return array;
        }
        
        int[] leftArray = Arrays.copyOfRange(array, 0, array.length/2);
        int[] rightArray = Arrays.copyOfRange(array, array.length/2, array.length);
        
        leftArray = mergeSortRecur(leftArray);
        rightArray = mergeSortRecur(rightArray);
        
        int[] returned = new int[array.length];
        
        int leftIndex = 0;
        int rightIndex = 0;
        
        for(int i = 0; i < returned.length; i++) {
            if(leftIndex >= leftArray.length) {
                returned[i] = rightArray[rightIndex++];
            }   
            else if(rightIndex >= rightArray.length) {
                returned[i] = leftArray[leftIndex++];
            }
            else if(rightArray[rightIndex] > leftArray[leftIndex]) {
                returned[i] = leftArray[leftIndex++];
            }
            else {
                returned[i] = rightArray[rightIndex++];
            }
        }
        
        return returned;
    }
}