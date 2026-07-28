class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int i =0;
        int j =n-1;
        int score =0;
        Arrays.sort(tokens);
        int max = 0;
        while(i<= j){
            if(power >= tokens[i]){
                score++;
                max = Math.max(max, score);
                power = power -tokens[i];
                i++;
            }
            else if(score >0){
                score--;
                power = power + tokens[j];
                j--;
            }
            else {break;}
        }
        return max;
    }
}