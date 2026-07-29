class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int steps = 0;
        int y = capacity;
        for(int i = 0; i<n; i++){ 
            if(capacity < plants[i]){
                capacity = y;
                steps = steps + i*2;
            }
            steps++;
            capacity -= plants[i];
        } 
        return steps;   
    }
}