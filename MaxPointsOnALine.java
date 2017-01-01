/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/max-points-on-a-line/
 */ 

public class MaxPointsOnALine {
    
    private int GCD(int a, int b){
        if(b == 0) return a; 
        return GCD(b, a%b);
    }
    
    public int maxPoints(Point[] points) {
        if(points == null) return 0; 
        int n = points.length; 
        if(n <= 2) return n; 
        int result = 0; 
        HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
        for(int i=0; i<=n-2; i++) {
            int overlaps=0, max=0;
            hm.clear(); 
            for(int j=i+1; j<=n-1; j++) {
                Point p1 = points[i]; 
                Point p2 = points[j];
                int numerator = p2.y-p1.y; 
                int denominator = p2.x-p1.x;
                int gcd = GCD(numerator,denominator); 
                if(gcd == 0) {
                    overlaps++; // Both numerator and denominator are 0, so the points are overlapping
                    continue; 
                }
                numerator /= gcd; 
                denominator /= gcd; 
                String slope = numerator + "/" + denominator; // This is not very efficient as key is a String
                if(!hm.containsKey(slope)) {
                    hm.put(slope,0); 
                } 
                int value = hm.get(slope); 
                hm.put(slope,value+1);
                max = Math.max(max,value+1);
            }
            max += overlaps;  
            result = Math.max(result,max+1); 
        }
        return result; 
    }
}