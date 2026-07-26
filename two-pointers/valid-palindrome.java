class Solution {
    public boolean isPalindrome(String s) {
        int j = 0;
        int k = s.length() -1;
        while(j<k){
            while(j<k && !Character.isLetterOrDigit(s.charAt(j))){
                j++;
            }
            while(j<k && !Character.isLetterOrDigit(s.charAt(k))){
                k--;
            }
            if(Character.toLowerCase(s.charAt(j)) != Character.toLowerCase(s.charAt(k))){
                 return false;
            }
            j++;
            k--;
        }
        return true;
    }
}