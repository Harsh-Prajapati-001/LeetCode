class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int r = s.length();
        int i =0;
        int j =0;
        while(j<n && i<r){
             if(t.charAt(j)==s.charAt(i)){
             i++;
            }
            j++;
        }

        return i==s.length();
        
    }
}