/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */ 

public class KDiffPair {
    public int findPairs(int[] nums, int k) {
        if(nums == null || k<0) return 0; 
        int pairCount=0; 
        HashMap<Integer,Integer> hm = new HashMap<>(); 
        for(int elem : nums) {
            if(!hm.containsKey(elem) && k != 0) {
                hm.put(elem,1);
                if(hm.containsKey(elem-k)) pairCount++;
                if(hm.containsKey(elem+k)) pairCount++;
            } else if(k == 0) {
                if(!hm.containsKey(elem)) {
                    hm.put(elem, 1); 
                } else {
                    int count = hm.get(elem);
                    if(count == 1) pairCount++; 
                    hm.put(elem,2); 
                }
            }
        }
        return pairCount;
    }
}