class Solution {
    public boolean isSubsequence(String s, String t) {
        int r = t.length();
        int n = s.length();
        int i =0;
        int j =0;
        while(j<r && i<n){
             if(t.charAt(j)==s.charAt(i)){
             i++;
            }
            j++;
        }

        return i==n;
        
    }
}