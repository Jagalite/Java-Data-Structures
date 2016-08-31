public class RadixSort {
    
    public void radixSort(int[] array) {
        
        int[] temp = new int[array.length];
        
        bitsPerPass = 4;
        
        boolean flag = true;
        
        for(int i = 0; i < 64; i += bitsPerPass) {
            
            if(flag) {
                radixSort(array, temp, i);
                flag = false;
            }
            else {
                radixSort(temp, array, i);
                flag = true;
            }
        }
        

        
    }
    
    private void radixSort(int[] array, int[] temp, int bit) {
        int numberOfBuckets = 1 << bitsPerPass;
        int mask = (1 << bitsPerPass)-1;
        
        int[] count = new int[numberOfBuckets]; 
        int[] map = new int[numberOfBuckets];
        
        for(int i = 0; i < array.length; i++) {
            count[(array[i] >> bit) & mask]++;
        }
        
        map[0] = 0;
        for(int i = 1; i < map.length; i++) {
            map[i] = count[i-1] + map[i-1];
        }
        
        for(int i = 0; i < array.length; i++) {
            temp[map[(array[i] >> bit) & mask]++] = array[i];
        }
        
    }
    
    int bitsPerPass;
}
