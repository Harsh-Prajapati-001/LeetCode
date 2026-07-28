import java.util.*;
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int count =0;
        int k = n-1;
        int i =0;
        Arrays.sort(people);
        while(i<=k ){
            if(people[i] +people[k] <= limit){
                i++;
            }
            k--;count++;
            
        }
        return count;

    }
}