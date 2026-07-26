import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b) ->{
            if(a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            } return Integer.compare(a[0] ,b[0]);
        });
        for(int [] interval : intervals){
            if(res.isEmpty() || res.get(res.size() -1)[1] < interval[0]){
                res.add(new int[]{interval[0], interval[1]});
            }
            else{
               int[] last = res.get(res.size()-1);
               last[1] = Math.max(last[1], interval[1]);
            }
            
        }
        return res.toArray(new int[res.size()][]);
        
    }
}