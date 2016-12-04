/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/number-of-boomerangs/
 */ 

public class CountBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points.length <= 2) return 0; 
        int result=0, n=points.length; 
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
        for(int i=0; i<=n-1; i++) {
            for(int j=0; j<=n-1; j++){
                if(i == j) continue; 
                int x = points[i][0] - points[j][0]; 
                int y = points[i][1] - points[j][1];
                int distanceSquare = x*x + y*y; 
                if(hm.containsKey(distanceSquare)){
                    int count = hm.get(distanceSquare); 
                    hm.put(distanceSquare,count+1); 
                } else {
                    hm.put(distanceSquare, 1); 
                }
            }
            for(Integer key : hm.keySet()){
                int val = hm.get(key); 
                result += val*(val-1);
            } 
            hm.clear();
        }
        return result;
    }
}