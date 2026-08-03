class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr2.length;
        int m = arr1.length;
        int i = 0;
        int k =0;
        while(i<n){
            for (int j =k; j<m; j++){
                if(arr1[j] ==arr2[i]){
                    int temp = arr1[k];
                    arr1[k] = arr1[j];
                    arr1[j] = temp;
                    k++;
                }
            }
            i++;
        }
        ArrayList<Integer> rest = new ArrayList<>();
        int z = k;
        while(k<m){
            rest.add(arr1[k]);
            k++;
        }
        Collections.sort(rest);
        for(int x =0; x<rest.size();x++){
            arr1[z] = rest.get(x);
            z++;
        }
        return arr1;
        
    }
}