class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int r = s.length();
        int i =0;
        int j =0;
        int [] ress = new int[r];
        boolean res = true;
        while(j<n && i<r){
            if(t.charAt(j)!= s.charAt(i)){
                j++;
            } else if(i < r && t.charAt(j)==s.charAt(i)){
             ress[i] =1;
             i++;
            }
        }
        for(int k =0; k<r;k++){
            if(ress[k] !=1){
                res =false;
            }
        }
        return res;
        
    }
}