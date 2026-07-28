class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int i =0;
        int j = n-1;
        while(i<j){
            char temp = s[i];
            char temp2 = s[j];
            s[j] =temp;
            s[i] = temp2;
            i++;
            j--;
        }
    
    }
}