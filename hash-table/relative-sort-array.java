class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for(int n :arr1){
            freq[n]++;
        }
        int[] result = new int[arr1.length];
        int idx =0;
        for(int i : arr2){
            while(freq[i]>0){
                result[idx] = i;
                idx++;
                freq[i]--;
            }
        }
        for(int j =0; j<=1000; j++){
            while(freq[j]>0){
                result[idx++] =j;
                freq[j]--;
            }
        }        
       return result; 
    }
}