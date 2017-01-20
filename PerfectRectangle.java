/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/perfect-rectangle/
 */ 

public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles == null || rectangles.length == 0) return false; 
        HashSet<String> hs = new HashSet<>(); 
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE, totalArea=0;
        
        for(int[] rectangle : rectangles){
            
            minX = Math.min(minX, rectangle[0]);
            maxX = Math.max(maxX, rectangle[2]);
            minY = Math.min(minY, rectangle[1]);
            maxY = Math.max(maxY, rectangle[3]);
            
            totalArea += (rectangle[2]-rectangle[0])*(rectangle[3]-rectangle[1]);
            
            String bottomLeft = rectangle[0] + "," + rectangle[1];
            String bottomRight = rectangle[2] + "," + rectangle[1];
            String topLeft = rectangle[0] + "," + rectangle[3];
            String topRight = rectangle[2] + "," + rectangle[3];
            
            if(!hs.contains(bottomLeft)) hs.add(bottomLeft);
            else hs.remove(bottomLeft);
            if(!hs.contains(bottomRight)) hs.add(bottomRight);
            else hs.remove(bottomRight);
            if(!hs.contains(topLeft)) hs.add(topLeft);
            else hs.remove(topLeft);
            if(!hs.contains(topRight)) hs.add(topRight);
            else hs.remove(topRight);
            
        }
        
        if(!hs.contains(minX + "," + minY) || 
           !hs.contains(maxX + "," + minY) ||
           !hs.contains(minX + "," + maxY) ||
           !hs.contains(maxX + "," + maxY) ||
           hs.size() != 4) {
           return false; 
        }
           
        return (totalArea == (maxX-minX)*(maxY-minY));
    }
}